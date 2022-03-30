package com.android.main.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.activityViewModels
import com.android.main.MainDataBean
import com.android.main.MainVM
import com.android.main.MyApplication
import com.android.main.R
import com.android.main.databinding.FragmentDevBinding
import com.android.main.databinding.FragmentMainBinding
import com.llj.baselib.IOTCallBack
import com.llj.baselib.IOTLib
import com.llj.baselib.IOTViewModel

class MainFragment:BaseFragment<FragmentMainBinding>(),IOTCallBack {

    override fun getLayoutId() = R.layout.fragment_main

    private val vm by activityViewModels<MainVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.isMainPage.postValue(true)
        vm.connectForFragment(this,MainDataBean::class.java)
    }

    override fun initCreateView() {
        super.initCreateView()
        val id = IOTLib.getSP(MyApplication.DEV_SP).getString(MyApplication.DEV_ID_SP,IOTLib.getUcb().deviceId)
        mDataBinding.tvDevId.text = "设备：$id"
        mDataBinding.boxFun.setOnClickListener {
            val isClick = mDataBinding.boxFun.isChecked
            if (isClick) vm.turnOnFun()
            else vm.turnOffFun()
        }
        mDataBinding.boxWindow.setOnClickListener {
            val isClick = mDataBinding.boxWindow.isChecked
            if (isClick) vm.turnOnWindow()
            else vm.turnOffWindow()
        }
    }

    override fun onStop() {
        super.onStop()
        vm.isMainPage.postValue(false)
    }

    @SuppressLint("ResourceAsColor")
    override fun offDevLine() {
        mDataBinding.tvDevState.setTextColor(R.color.red)
        mDataBinding.tvDevState.text = "设备离线"
    }

    @SuppressLint("ResourceAsColor")
    override fun onDevLine() {
        mDataBinding.tvDevState.setTextColor(R.color.greenDark)
        mDataBinding.tvDevState.text = "设备在线"
    }

    override fun realData(data: Any?) {
        if (data == null) return
        val d = data as MainDataBean
        val t = "${d.temp} °c"
        mDataBinding.tvTemp.text = t
        val h = "${d.humi} %"
        mDataBinding.tvHump.text = h
        val c = "${d.co2} ppm"
        mDataBinding.tvCo2.text = c
        val p = "${d.pm25} μg/m3"
        mDataBinding.tvPm25.text = p
    }

    override fun webState(state: IOTViewModel.WebSocketType) {

    }

}