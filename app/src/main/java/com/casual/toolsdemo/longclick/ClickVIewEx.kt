package com.casual.toolsdemo.longclick

import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View

fun View.longClick(handler: Handler? = null, deleyMillion: Long, callback: ((View) -> Unit)? = null) {
    //如果没有自定义handler，就用生成一个
    val mHandler = handler ?: Handler(Looper.getMainLooper())
    val runnable = Runnable {
        callback?.invoke(this)
    }
    setOnTouchListener { view, motionEvent ->
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                mHandler.removeCallbacksAndMessages(null)
                mHandler.postDelayed(runnable, deleyMillion)
            }
            MotionEvent.ACTION_UP -> {
                mHandler.removeCallbacksAndMessages(null)
            }
        }
        true
    }

}