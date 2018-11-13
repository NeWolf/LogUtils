package com.newolf.logutilslib

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import java.lang.reflect.InvocationTargetException

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2018/11/13
 * 描述:
 * 历史:<br/>
 * ================================================
 */

object Utils {

    @SuppressLint("StaticFieldLeak")
    private var sApplication: Application? = null

    fun init(app: Application?) {
        if (sApplication == null) {
            if (app == null) {
                sApplication = getApplicationByReflect()
            } else {
                sApplication = app
            }

        }
    }

    private fun getApplicationByReflect(): Application {
        try {
            @SuppressLint("PrivateApi")
            val activityThread = Class.forName("android.app.ActivityThread")
            val thread = activityThread.getMethod("currentActivityThread").invoke(null)
            val app = activityThread.getMethod("getApplication").invoke(thread)
                ?: throw NullPointerException("u should init first")
            return app as Application
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }

        throw NullPointerException("u should init first")
    }

    fun getApp(): Context {
        return sApplication as Context
    }

}