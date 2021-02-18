package com.xinshuwu.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.gyf.immersionbar.ImmersionBar;
import com.xinshuwu.XswApplication;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Utils {
    public static Spanned fromHtml(String source) {
        if (TextUtils.isEmpty(source)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(source);
        }
    }

    public static void toolbar(Context context, int color){
        ImmersionBar.with((Activity) context)
                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
                .navigationBarDarkIcon(true) //导航栏图标是深色，不写默认为亮色
                .autoDarkModeEnable(true) //自动状态栏字体和导航栏图标变色，必须指定状态栏颜色和导航栏颜色才可以自动变色哦
                .autoStatusBarDarkModeEnable(true,0.2f) //自动状态栏字体变色，必须指定状态栏颜色才可以自动变色哦
                .autoNavigationBarDarkModeEnable(true,0.2f)
                .fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
                .statusBarColor(color)
                .init();
    }


    public static boolean isActivityAlive(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (activity.isDestroyed()) {
                return false;
            }
        }
        return true;
    }


    public static void toolbsrText(Context context,int colorId){
        ((Activity)context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        ((Activity)context).getWindow().setStatusBarColor(context.getResources().getColor(colorId));
    }


    public static boolean isPackageExisted(Context context, String packageName) {
        if (StringUtil.isEmpty(packageName)) {
            return false;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Exception e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressWarnings("deprecation")
    public static void copyToClipboard(Context context, String content) {
        try {
            if (Build.VERSION.SDK_INT > 11) {
                android.content.ClipboardManager cmb = (android.content.ClipboardManager) context
                        .getSystemService(Context.CLIPBOARD_SERVICE);
                cmb.setPrimaryClip(ClipData.newPlainText(null, content));
            } else {
                android.text.ClipboardManager cmb = (android.text.ClipboardManager) context
                        .getSystemService(Context.CLIPBOARD_SERVICE);
                cmb.setText(content);
            }
        } catch (Exception e) {
        }
    }

    public static void openApp(Context context, String packageName) throws PackageManager.NameNotFoundException {
        PackageInfo pi = context.getPackageManager().getPackageInfo(packageName, 0);

        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(pi.packageName);

        List<ResolveInfo> apps = context.getPackageManager().queryIntentActivities(resolveIntent, 0);

        Iterator<ResolveInfo> iterator = apps.iterator();
        while (iterator.hasNext()) {
            ResolveInfo ri = iterator.next();
            if (ri != null) {
                packageName = ri.activityInfo.packageName;
                String className = ri.activityInfo.name;
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                ComponentName cn = new ComponentName(packageName, className);
                intent.setComponent(cn);
                context.startActivity(intent);
            }
        }
    }

    public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean isClassMember(String key, Class c) {
        if (StringUtil.isEmpty(key)) {
            return false;
        }
        Field[] fs = c.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true);
            try {
                if (key.equals(f.getName())) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static String getAppChannel(Context context) {
        String appChannel = "";
        try {
            Bundle metaData = context.getPackageManager().getApplicationInfo(context.getPackageName(),
                    PackageManager.GET_META_DATA).metaData;
            appChannel = (String) metaData.get("UMENG_CHANNEL");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return appChannel != null ? appChannel : "";
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
        return temp;
    }

    public static void showToast(Context context, int id) {
        Toast.makeText(XswApplication.Companion.instance(), XswApplication.Companion.instance().getResources().getString(id),
                Toast.LENGTH_SHORT).show();
    }


    public static void showToast(String s) {
        Toast.makeText(XswApplication.Companion.instance(), s, Toast.LENGTH_SHORT).show();
    }


    public static void showToast(Context context, String string) {
        if (!StringUtil.isEmpty(string)) {
            Toast.makeText(XswApplication.Companion.instance(), string, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showToastLong(Context context, int id) {
        Toast.makeText(XswApplication.Companion.instance(), XswApplication.Companion.instance().getResources().getString(id), Toast.LENGTH_LONG)
                .show();
    }

    public static void showToastLong(Context context, String string) {
        if (!StringUtil.isEmpty(string)) {
            Toast.makeText(XswApplication.Companion.instance(), string, Toast.LENGTH_LONG).show();
        }
    }

    public static void showToast(String string, long duration) {
        final Toast toast = Toast.makeText(XswApplication.Companion.instance(), string, Toast.LENGTH_SHORT);
        toast.show();
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                toast.show();
            }

            @Override
            public void onFinish() {
                toast.show();
            }

        }.start();
    }

    public static int getVersionCode() {
        int versionCode = Integer.MAX_VALUE;
        try {
            versionCode = XswApplication.Companion.instance().getPackageManager()
                    .getPackageInfo(XswApplication.Companion.instance().getPackageName(), 0).versionCode;
        } catch (Exception e) {
        }
        return versionCode;
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static Map<String, Object> buildMap(Object... keyValues) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        for (int i = 0; i < keyValues.length; i += 2) {
            resultMap.put((String) keyValues[i], keyValues[i + 1]);
        }
        return resultMap;
    }

    public static void startApkInstall(Context context, String path) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse("file://" + path), "application/vnd.android.package-archive");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(i);
        } catch (Exception re) {
        }
    }

    public static boolean isVersionEqualOrNewerThan(int version) {
        return Build.VERSION.SDK_INT >= version;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static boolean checkLenovoDevice() {
        if (DeviceUtil.getManufacturer() != null && DeviceUtil.getManufacturer().toLowerCase().contains("lenovo")) {
            return true;
        }
        return false;
    }


    public static String getTimeDesc(int seconds) {
        String result = "";
        int second = seconds % 60;
        if (second != 0) {
            result += second + "秒";
        }
        int minute = (seconds / 60) % 60;
        if (minute != 0) {
            result = minute + "分钟" + result;
        }
        int hour = seconds / 3600;
        if (hour > 0) {
            result = hour + "小时" + result;
        }
        if (StringUtil.isEmpty(result)) {
            return "0秒";
        }
        return result;

    }

    public static String getAndroidId() {
        String androidId = null;
        try {
            Context context = XswApplication.Companion.instance();
            ContentResolver contentResolver = context.getContentResolver();
            androidId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID);
        } catch (Exception e) {
        }
        if (StringUtil.isEmpty(androidId)) {
            androidId = "0";
        }

        return androidId;
    }

    public static int getDeviceWidth(Context context) {
        return getDeviceSize(context)[0];
    }

    public static int getDeviceHeight(Context context) {
        return getDeviceSize(context)[1];
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static int[] getDeviceSize(Context context) {
        int[] size = new int[2];

        int measuredWidth = 0;
        int measuredHeight = 0;
        Point point = new Point();
        WindowManager wm = ((WindowManager) XswApplication.Companion.instance().getSystemService(Context.WINDOW_SERVICE));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            wm.getDefaultDisplay().getSize(point);
            measuredWidth = point.x;
            measuredHeight = point.y;
        } else {
            DisplayMetrics dm = XswApplication.Companion.instance().getResources().getDisplayMetrics();
            measuredWidth = dm.widthPixels;
            measuredHeight = dm.heightPixels;
        }

        size[0] = measuredWidth;
        size[1] = measuredHeight;
        return size;
    }
}
