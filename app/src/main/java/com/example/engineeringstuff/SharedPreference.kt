package com.example.engineeringstuff

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager (context: Context) {
    private val SP_NAME = "spName"
    private val SP_EMAIL = "spEmail"
    private val SP_ISLOGIN = "spIsLogin"
    private val sharedPreference: SharedPreferences = context.getSharedPreferences("LoggedIn", Context.MODE_PRIVATE)
    private val spEditor = sharedPreference.edit()

    fun saveSpString(spKey: String, value: String) {
        spEditor.putString(spKey, value)
        spEditor.apply()
    }

    fun saveSpInt(spKey: String, value: Int) {
        spEditor.putInt(spKey, value)
        spEditor.apply()
    }

    fun saveSpEmail(spKey: String, value: String) {
        spEditor.putString(spKey, value)
        spEditor.apply()
    }

    fun saveSpRole(spKey: String, value: String) {
        spEditor.putString(spKey, value)
        spEditor.apply()
    }

    fun saveSpBoolean(spKey: String, value: Boolean) {
        spEditor.putBoolean(spKey, value)
        spEditor.apply()
    }

    fun getName(): String? {
        return sharedPreference.getString(SP_NAME, "")
    }

    fun getEmail(): String? {
        return sharedPreference.getString(SP_EMAIL, "")
    }

    fun isLogin(): Boolean? {
        return sharedPreference.getBoolean(SP_ISLOGIN, false)
    }
    fun getString(key: String): String? {
        return sharedPreference.getString(key, "")
    }
    fun clearSession() {
        spEditor.clear()
        spEditor.apply()
    }

}