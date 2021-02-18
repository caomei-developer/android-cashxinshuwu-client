package com.xinshuwu.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.InputDevice;

import com.xinshuwu.XswApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DeviceUtil {
	private static final String LOCAL_IMEI = "local_imei";

	public static String getModel() {
		return Build.MODEL;
	}

	public static String getBrand() {
		return Build.BRAND;
	}

	public static String getManufacturer() {
		return Build.MANUFACTURER;
	}

	public static String getOsVersion() {
		return Build.VERSION.RELEASE;
	}

	public static String getAndroidId(Context context) {
		try {
			ContentResolver contentResolver = context.getContentResolver();
			return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID);
		} catch (Exception e) {
		}
		return null;
	}

	public static String getMacAddress(Context context) {
		try {
			WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
			return wm.getConnectionInfo().getMacAddress();
		} catch (Exception e) {
		}
		return null;
	}

	@SuppressLint("MissingPermission")
	public static String getImei(Context context) {
		try {
			TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			if (tm != null) {
				return tm.getDeviceId();
			}
		} catch (Exception e) {
		}
		return null;
	}

	@SuppressLint("MissingPermission")
	public static String getLocalImei(Context context) {
		String imei = PreferenceManager.getInstance().getPreferencesString(LOCAL_IMEI);
		if (!StringUtil.isEmpty(imei)) {
			return imei;
		}
		try {
			TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			if (tm != null) {
				imei = tm.getDeviceId();
			}
		} catch (Exception e) {
		} finally {
			if (StringUtil.isEmpty(imei)) {
				int random = (int) ((Math.random() * 9 + 1) * 100);
				long time = System.currentTimeMillis();
				imei = "" + time + "" + random;
				PreferenceManager.getInstance().savePreferencesString(LOCAL_IMEI, imei);
			}
			return imei;
		}

	}

	public static  String getPhone(Context context){

        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (tm != null) {
                String tel = tm.getLine1Number();//手机号码
                return tel;
            }
        } catch (Exception e) {
        }
        return null;


    }

	public static String getImsi(Context context) {
		try {
			TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			if (tm != null) {
				return tm.getSubscriberId();
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static float getDensity(Context context) {
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		return dm.density;
	}

	public static int getScreenWidth(Context context) {
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		return dm.widthPixels;
	}

	public static int getScreenHeight(Context context) {
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		return dm.heightPixels;
	}

	public static final String getSDKVersion() {
		return Build.VERSION.RELEASE;
	}

	public static String getHardware() {
		return Build.HARDWARE;
	}

	public static String getBoard() {
		return Build.BOARD;
	}

	public static String getCpuInfo() {
		try {
			FileReader fr = new FileReader("/proc/cpuinfo");
			BufferedReader br = new BufferedReader(fr);
			String text = br.readLine();
			String[] array = text.split(":\\s+", 2);
			return array[1];
		} catch (Exception e) {
		}
		return null;
	}


	public static long getMemorySize() {
		try {
			FileInputStream fis = new FileInputStream(new File("/proc/meminfo"));
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
			String memTotal = bufferedReader.readLine();
			StringBuffer sb = new StringBuffer();
			for (char c : memTotal.toCharArray()) {
				if (c >= '0' && c <= '9') {
					sb.append(c);
				}
			}
			long totalMemory = Long.parseLong(sb.toString()) * 1024;
			return totalMemory;
		} catch (Exception e) {
			return 0;
		}
	}

	public static List getInputDevice() {
		try {
			List<String> list = new ArrayList<>();
			if (hasMouse()) {
				list.add("mouse");
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static boolean hasMouse() {
		try {
			int[] deviceIds = InputDevice.getDeviceIds();
			for (int deviceId : deviceIds) {
				InputDevice inputDevice = InputDevice.getDevice(deviceId);
				int sources = inputDevice.getSources();
				if (((sources & InputDevice.SOURCE_MOUSE) == InputDevice.SOURCE_MOUSE)) {
					return true;
				}
			}
		} catch (Exception e) {
		}
		return false;
	}

	public static List<String> getSensorList() {
		List<String> result = new ArrayList<>();
		try {
			SensorManager sensorManager = (SensorManager) XswApplication.Companion.instance()
					.getSystemService(Context.SENSOR_SERVICE);
			List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
			for (Sensor sensor : sensorList) {
				result.add(sensor.getName());
			}
		} catch (Exception e) {
		}
		return result;
	}
}
