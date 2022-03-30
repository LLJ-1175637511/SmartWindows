package com.android.main.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.main.DevDataBean
import com.android.main.MyApplication
import com.android.main.R
import com.android.main.databinding.ItemDevBinding
import com.llj.baselib.IOTLib
import com.llj.baselib.save
import com.llj.baselib.utils.ToastUtils

class DeviceRV(private val list: MutableList<DevDataBean>) : RecyclerView.Adapter<DeviceRV.Holder>() {

    class Holder(private val binding: ItemDevBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(item:DevDataBean){
            val t = "设备：${item.id}"
            binding.tvDevId.text = t
            binding.tvLocation.text = item.location
            binding.root.setOnClickListener {
                IOTLib.getSP(MyApplication.DEV_SP).save {
                    putString(MyApplication.DEV_ID_SP,item.id.toString())
                }
                ToastUtils.toastShort("设备${item.id}绑定成功 前往主页查看详情")
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(inputText:String){
        val newList = list.find {
            it.id.toString() == inputText
        }
        if (newList == null){
            ToastUtils.toastShort("未搜索到对应设备")
        }else{
            list.clear()
            list.add(newList)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = DataBindingUtil.inflate<ItemDevBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_dev,
            parent,
            false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount() = list.size

}