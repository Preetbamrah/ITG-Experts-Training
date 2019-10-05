package com.example.itgexperttraining.activities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    private Retrofit retrofit;
    private static ApiManager instance = new ApiManager();
    private static final String LOGIN_URL = "http://unabpgatepass.com/students/securitysystem/index.php/api/";


    //create listener interface
    public interface Callback {
        String onResult(boolean z, String response);
    }

    public static ApiManager getInstance() {
        if (instance != null) {
            return instance;
        }
        else {
            return instance = new ApiManager();
        }
    }

    private void init() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)

                //Interceptors are a powerful mechanism that can monitor, rewrite, and retry calls

                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        okhttp3.Request original = chain.request();
                        okhttp3.Request.Builder requestBuilder = original.newBuilder();

                        requestBuilder.addHeader("Accept", "application/json");


                        okhttp3.Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                })
                .build();

        //to buid retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(LOGIN_URL)

                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }


    private ApiManager() {
        init();
    }


    //to use Callback Response

    /*public void login(final Callback callback,String email,String password) {

        MainApi service = retrofit.create(MainApi.class);
        Call<ResponseBody> result = service.login(email,password);
        result.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull retrofit2.Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        if (callback != null) {
                            callback.onResult(true, "" + response.body().string());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (callback != null) {
                            callback.onResult(false, "Error");
                        }
                    }
                } else {
                    if (callback != null)
                        if (response.code() == 409) {
                            try {
                                callback.onResult(false, response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                                callback.onResult(false, "Somethink wrong!....");
                            }
                        }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, Throwable t) {
                t.fillInStackTrace();
                if (callback != null) {
                    callback.onResult(false, "" + t.getMessage());
                }
            }

        });
    }*/
}

