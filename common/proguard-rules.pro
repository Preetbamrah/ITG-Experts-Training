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
-keepclassmembers class ** {
   public static *** pure(...);
}
-dontwarn okio.**
-ignorewarnings
-keep public class com.google.android.gms.* { public *; }
-dontwarn com.google.android.gms.**
-dontwarn com.google.firebase.messaging.**
-keepattributes Signature
-keepattributes *Annotation*
# Add this global rule
-keepattributes Signature

# This rule will properly ProGuard all the model classes in
# the package com.yourcompany.models. Modify to fit the structure
# of your app.
  -keepclassmembers class com.example.senderside.** {
*;
}
-dontwarn com.firebase.**
-keep class com.firebase.** { *; }
-keep interface com.firebase.** { *; }

-keep class io.card.**
-keepclassmembers class io.card.** { *; }
-keep class com.lowagie.text.** { *; }
-keep class android.support.v7.widget.** { *; }
-keep interface android.support.v7.widget.** { *; }
-keepattributes SourceFile,LineNumberTable
-keep class com.nostra13.** { *; }
-keepclassmembers class com.nostra13.** { *; }
-keep class com.google.android.gms.internal.** { *; }
-keep public class com.google.android.gms.* { public *; }
-dontwarn com.google.android.gms.**
-keep class com.apptimize.** { *; }
-keepclassmembers class * extends com.apptimize.ApptimizeTest {
  <methods>;
}
#https://apptimize.com/docs/installation/android-installation.html#initializing-apptimize Step 4
-keep class com.mixpanel.android.mpmetrics.MixpanelAPI { *; }
-keep class com.google.android.gms.analytics.Tracker { *; }
-keep class com.google.analytics.tracking.android.Tracker { *; }