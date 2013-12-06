package cn.sh.mhedu.mhzx.digitalcampus.database;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferenceManager {
	
	private static final String FILE_SIGN_UP = "sign_up";
	
	private static final String KEY_ENTRY_COURSE_SIGN_IN = "entry_course_sign_in";
	private static final String KEY_ENTRY_COURSE_ACCOUNT = "entry_course_account";
	private static final String KEY_ENTRY_COURSE_PASSWORD = "entry_course_password";
	
	private static final String KEY_INFORMATION_SOFTWARE_SIGN_IN = "information_software_sign_in";
	private static final String KEY_INFORMATION_SOFTWARE_ACCOUNT = "information_software_account";
	private static final String KEY_INFORMATION_SOFTWARE_PASSWORD = "information_software_password";
	
	private MyPreferenceManager() {
	}
	
	private static SharedPreferences getSharedPreferences(Context context) {
		return context.getSharedPreferences(FILE_SIGN_UP, Context.MODE_PRIVATE);
	}
	
	public static void setEntryCourseSignIn(Context context, boolean isSignIn) {
		SharedPreferences preference = getSharedPreferences(context);
		preference.edit().putBoolean(KEY_ENTRY_COURSE_SIGN_IN, isSignIn).commit();
	}
	
	/**
	 * @param context
	 * @return default false
	 */
	public static boolean getEntryCourseSignIn(Context context) {
		return getSharedPreferences(context).getBoolean(KEY_ENTRY_COURSE_SIGN_IN, true);
	}
	
	public static void setEntryCourseAccount(Context context, String account) {
		SharedPreferences preferences = getSharedPreferences(context);
		preferences.edit().putString(KEY_ENTRY_COURSE_ACCOUNT, account).commit();
	}
	
	/**
	 * @param context
	 * @return default null
	 */
	public static String getEntryCourseAccount(Context context) {
		return getSharedPreferences(context).getString(KEY_ENTRY_COURSE_ACCOUNT, null);
	}
	
	public static void setEntryCoursePassword(Context context, String password) {
		SharedPreferences preferences = getSharedPreferences(context);
		preferences.edit().putString(KEY_ENTRY_COURSE_PASSWORD, password).commit();
	}
	
	/**
	 * @param context
	 * @return default null
	 */
	public static String getEntryCoursePassword(Context context) {
		return getSharedPreferences(context).getString(KEY_ENTRY_COURSE_PASSWORD, null);
	}
	
	public static void setInformationSoftwareSignIn(Context context, boolean isSignIn) {
		SharedPreferences preference = getSharedPreferences(context);
		preference.edit().putBoolean(KEY_INFORMATION_SOFTWARE_SIGN_IN, isSignIn).commit();
	}
	
	/**
	 * @param context
	 * @return default false
	 */
	public static boolean getInformationSoftwareSignIn(Context context) {
		return getSharedPreferences(context).getBoolean(KEY_INFORMATION_SOFTWARE_SIGN_IN, false);
	}
	
	public static void setInformationSoftwareAccount(Context context, String account) {
		SharedPreferences preferences = getSharedPreferences(context);
		preferences.edit().putString(KEY_INFORMATION_SOFTWARE_ACCOUNT, account).commit();
	}
	
	/**
	 * @param context
	 * @return default null
	 */
	public static String getInformationSoftwareAccount(Context context) {
		return getSharedPreferences(context).getString(KEY_INFORMATION_SOFTWARE_ACCOUNT, null);
	}
	
	public static void setInformationSoftwarePassword(Context context, String password) {
		SharedPreferences preferences = getSharedPreferences(context);
		preferences.edit().putString(KEY_INFORMATION_SOFTWARE_PASSWORD, password).commit();
	}
	
	/**
	 * @param context
	 * @return default null
	 */
	public static String getInformationSoftwarePassword(Context context) {
		return getSharedPreferences(context).getString(KEY_INFORMATION_SOFTWARE_PASSWORD, null);
	}

}
