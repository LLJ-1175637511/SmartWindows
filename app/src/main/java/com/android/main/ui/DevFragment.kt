package com.android.main.ui

import androidx.recyclerview.widget.GridLayoutManager
import com.android.main.DevDataBean
import com.android.main.R
import com.android.main.databinding.FragmentDevBinding
import com.llj.baselib.IOTLib

class DevFragment : BaseFragment<FragmentDevBinding>() {

    override fun getLayoutId() = R.layout.fragment_dev

    private val rv by lazy {
        DeviceRV(initDevData())
    }

    override fun initCreateView() {
        super.initCreateView()

        mDataBinding.recyclerView.apply {
            this.layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = rv
        }

        mDataBinding.tvSearch.setOnClickListener {
            rv.update(mDataBinding.etDevId.text.toString())
            hideKeyboard()
        }

    }

    private fun initDevData():MutableList<DevDataBean> {
        val list = mutableListOf<DevDataBean>()
        list.add(DevDataBean(IOTLib.getUcb().deviceId.toInt(), "卧室"))
        list.add(DevDataBean(IOTLib.getUcb().deviceId.toInt() - 2, "厨房"))
        list.add(DevDataBean(IOTLib.getUcb().deviceId.toInt() - 5, "洗手间"))
        return list
    }

}