package com.example.qube.jjspost.setup;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by stacyzolnikov on 8/18/16.
 */
public class SessionManager {
    SharedPreferences mPreferences;
    Editor mEditor;
    Context mContext;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "com.example.qube.jjspost.activities";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_EMAIL = "email";

    public SessionManager(Context mContext) {
        this.mContext = mContext;
        mPreferences= mContext.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        mEditor = mPreferences.edit();
    }

    public void createLoginSession(String email){
        mEditor.putBoolean(IS_LOGIN, true);
        mEditor.putString(KEY_EMAIL, email);
        mEditor.commit();
    }


}
