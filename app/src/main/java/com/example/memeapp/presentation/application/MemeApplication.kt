package com.example.memeapp.presentation.application

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MemeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        var builder = RealmConfiguration.Builder()
        builder.allowWritesOnUiThread(true)
        Realm.setDefaultConfiguration(builder.build())
    }
}
