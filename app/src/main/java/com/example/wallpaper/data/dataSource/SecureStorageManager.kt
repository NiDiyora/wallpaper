package com.example.wallpaper.data.dataSource

import android.content.Context
import android.content.SharedPreferences
import com.example.wallpaper.StorageConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface ISecureStorageManager{

    var userID:String
    var token:String
}

class SecureStorageManager @Inject constructor(@ApplicationContext context: Context,

):ISecureStorageManager {

    companion object{
        const val USER_ID ="USER_ID"
        const val TOKEN = "TOKEN"
    }
    private val encryptedPrefs: SharedPreferences =
        context.getSharedPreferences(StorageConfig.SECURE_SHARED_PREFERENCES_FILE_NAME, 0)

    override var userID: String by StringPreferenceDelegate(encryptedPrefs, USER_ID)
    override var token: String by StringPreferenceDelegate(encryptedPrefs, TOKEN)


}