package com.android.main

import androidx.lifecycle.MutableLiveData
import com.llj.baselib.IOTCallBack
import com.llj.baselib.IOTViewModel

class MainVM:IOTViewModel() {

    val isMainPage = MutableLiveData<Boolean>(false)

    private var isVMInit = false

    fun connectForFragment(callBack: IOTCallBack, jClass: Class<*>){
        if (isVMInit) return
        connect(callBack, jClass)
        isVMInit = true
    }

    fun turnOnFun() {
        sendOrderToDevice("A")
    }

    fun turnOffFun() {
        sendOrderToDevice("B")
    }

    fun turnOnWindow() {
        sendOrderToDevice("D")
    }

    fun turnOffWindow() {
        sendOrderToDevice("C")
    }


}