package com.android.main.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.android.main.R

abstract class BaseFragment<DB : ViewDataBinding> : Fragment() {

    abstract fun getLayoutId(): Int

    lateinit var mDataBinding: DB

    open fun initCreate() {}

    open fun initCreateView() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initCreate()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mDataBinding = DataBindingUtil.inflate<DB>(inflater, getLayoutId(), container, false)
        mDataBinding.lifecycleOwner = this
        initCreateView()
        return mDataBinding.root
    }

    fun hideKeyboard() {
        //隐藏软键盘
        (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
            requireActivity().currentFocus?.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        mDataBinding.unbind()
    }

    fun <T : Activity> startActivityAndFinish(activity: Class<T>) {
        requireActivity().startActivity(Intent(requireContext(), activity))
        requireActivity().finish()
    }

    inline fun <reified T : Activity> startActivityAndFinish() {
        startActivityAndFinish(T::class.java)
    }

}