package com.example.wallpaper.data.dataSource

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.wallpaper.StorageConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface IPreferencesStorage {
    fun clearAll()
}


class PreferencesStorage @Inject constructor(@ApplicationContext context: Context) :
    IPreferencesStorage {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(
            StorageConfig.SHARED_PREFERENCES_FILE_NAME,
            Context.MODE_PRIVATE
        )
    override fun clearAll() {
        prefs.edit {
            clear()
        }
    }

}