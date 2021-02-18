package com.xinshuwu.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.xinshuwu.XswApplication;


public class PreferenceManager {

	private static PreferenceManager instance;
	private SharedPreferences preference;

	private static final String PREPERENCE_KEY = "xsw.preferences";

	private PreferenceManager(Context context) {
		preference = context.getSharedPreferences(PREPERENCE_KEY, Context.MODE_PRIVATE);
	}

	public static PreferenceManager getInstance(Context context) {
		if (instance == null) {
			instance = new PreferenceManager(context);
		}
		return instance;
	}

	public static PreferenceManager getInstance() {
		if (instance == null) {
			Context context = XswApplication.Companion.instance().getApplicationContext();
			instance = new PreferenceManager(context);
		}
		return instance;
	}

	public void savePreferencesString(String key, String value) {
		Editor editor = preference.edit();
		editor.putString(key, value);
		editor.apply();
	}

	public void savePreferencesTwoValueString(Object... keyValues) {
		Editor editor = preference.edit();
		for (int i = 0; i < keyValues.length; i += 2) {
			editor.putString((String) keyValues[i], (String) keyValues[i + 1]);
		}
		editor.apply();
	}

	public String getPreferencesString(String key) {
		return preference.getString(key, null);
	}

	public void savePreferencesBoolean(String key, boolean value) {
		Editor editor = preference.edit();
		editor.putBoolean(key, value);
		editor.apply();
	}

	public boolean getPreferencesBoolean(String key, boolean defValue) {
		return preference.getBoolean(key, defValue);
	}

	public void savePreferencesInteger(String key, int value) {
		Editor editor = preference.edit();
		editor.putInt(key, value);
		editor.apply();
	}

	public int getPreferencesInteger(String key, int defValue) {
		return preference.getInt(key, defValue);
	}

	public long getPreferencesLong(String key, long defValue) {
		return preference.getLong(key, defValue);
	}

	public void savePreferencesLong(String key, long value) {
		Editor editor = preference.edit();
		editor.putLong(key, value);
		editor.apply();
	}

	public void removePreferences(String key) {
		Editor editor = preference.edit();
		editor.remove(key);
		editor.apply();
	}
}
