# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-dontwarn com.example.senderside.**
-keep class *{
 public private *;
 }
-keep public class com.google.android.gms.* { public *; }
-dontwarn com.google.android.gms.**
-keep class com.google.android.** { *; }

-dontwarn com.google.android.**
-keep class com.google.android.gms.internal.** { *; }
-keep class com.google.gson.** { *; }
-dontwarn com.google.android.gms.internal.zzhu
-dontwarn java.nio.file.Files
-dontwarn java.nio.file.Path
-dontwarn java.nio.file.OpenOption
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-keepattributes Signature
-keepattributes *Annotation*
-dontwarn com.google.firebase.messaging.**
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify

-keepattributes EnclosingMethod
-keepattributes InnerClasses

-dontwarn org.xmlpull.v1.**
-dontnote org.xmlpull.v1.**
-keep class org.xmlpull.** { *; }
-keepclassmembers class org.xmlpull.** { *; }

# Only necessary if you downloaded the SDK jar directly instead of from maven.
-keep class com.shaded.fasterxml.jackson.** { *; }
-keepattributes EnclosingMethod
-keepattributes InnerClasses

-keep class com.example.senderside.** { *; }
-dontwarn okio.**
-dontwarn retrofit2.Call
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-keep class android.support.v7.widget.RecyclerView { *; }
-keep class persistence.** {
  *;
}
-dontwarn kotlin.Unit

#Top-level functions that can only be used by Kotlin.
-dontwarn retrofit2.-KotlinExtensions
-dontwarn kotlin.**

-dontwarn com.squareup.okhttp.**
-dontwarn okhttp3.internal.platform.*
-dontwarn org.conscrypt.*

-libraryjars   libs/android-support-v4.jar
-dontwarn android.support.**
-keep class android.support.** { *; }
-keep interface android.support.app.** { *; }
-keepattributes *Annotation*

-dontoptimize
-dontpreverify