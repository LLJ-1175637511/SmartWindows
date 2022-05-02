package com.android.main

import androidx.lifecycle.MutableLiveData
import com.llj.baselib.IOTCallBack
import com.llj.baselib.IOTViewModel

class MainVM:IOTViewModel() {

    val isMainPage = MutableLiveData<Boolean>(false)

    private var isVMInit = false

    fun connectForFragment(callBack: IOTCallBack, jClass: Class<*>){
        if (isVMInit){
            return
        }
        connect(callBack, jClass)
        isVMInit = true
    }

    //是否为自动
    var isMode = false

    /**
     * 自动
     */
    fun turnOnMode() {
        isMode = true
        sendOrderToDevice("C")
    }

    /**
     * 手动
     */
    fun turnOffMode() {
        isMode = false
        sendOrderToDevice("D")
    }

    fun turnOnWindow() {
        sendOrderToDevice("A")
    }

    fun turnOffWindow() {
        sendOrderToDevice("B")
    }

}