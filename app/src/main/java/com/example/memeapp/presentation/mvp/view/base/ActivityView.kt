package com.example.memeapp.presentation.mvp.view.base

import android.app.Activity
import android.content.Context
import java.lang.ref.WeakReference

open class ActivityView(activity: Activity) {
    private val activityRef: WeakReference<Activity>
    val activity: Activity?
        get() = activityRef.get()
    val context: Context?
        get() = activity

    init {
        activityRef = WeakReference(activity)
    }
}
