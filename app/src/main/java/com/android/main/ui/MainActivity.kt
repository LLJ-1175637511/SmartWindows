package com.android.main.ui

import android.annotation.SuppressLint
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.main.MainDataBean
import com.android.main.MainVM
import com.android.main.R
import com.android.main.databinding.ActivityMainBinding
import com.llj.baselib.IOTViewModel
import com.llj.baselib.ui.IOTMainActivity
import com.llj.baselib.utils.ToastUtils

class MainActivity : IOTMainActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    private val vm by viewModels<MainVM>()

    override fun init() {
        super.init()
        initNav()
        initMainView()
    }

    private fun initNav() {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        mDataBinding.navView.setupWithNavController(navController)
    }

    private fun initMainView() {
        vm.isMainPage.observe(this){
            mDataBinding.toolbar.toolbarBase.visibility = if (it) View.GONE
            else View.VISIBLE
        }

    }

    @SuppressLint("ResourceAsColor")
    override fun offDevLine() {
    }

    @SuppressLint("ResourceAsColor")
    override fun onDevLine() {
    }

    override fun realData(data: Any?) {
        ToastUtils.toastShort("data:${(data as MainDataBean).toString()}")
    }

    override fun webState(state: IOTViewModel.WebSocketType) {
    }

    private fun showDialog(df: DialogFragment, tag: String) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        val prev: Fragment? = supportFragmentManager.findFragmentByTag(tag)
        if (prev != null) {
            ft.remove(prev)
        }
        ft.addToBackStack(null)
        df.show(ft, tag)
    }

}