package com.android.main.ui

import android.content.Intent
import android.net.Uri
import com.android.main.R
import com.android.main.databinding.FragmentDevBinding
import com.android.main.databinding.FragmentMineBinding
import com.llj.baselib.utils.ToastUtils

class MineFragment:BaseFragment<FragmentMineBinding>() {

    override fun getLayoutId() = R.layout.fragment_mine

    override fun initCreateView() {
        super.initCreateView()
        mDataBinding.tvCallCenter.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${13889333415}"))
            requireActivity().startActivity(dialIntent)
        }
        mDataBinding.tvAboutMe.setOnClickListener {
            ToastUtils.toastShort("创于2022年3月20日")
        }
        mDataBinding.tvQuit.setOnClickListener {
            startActivityAndFinish<LoginActivity>()
        }
        mDataBinding.tvUserInfo.setOnClickListener {
            ToastUtils.toastShort("用户信誉良好 暂无不良记录")
        }
    }

}