package com.lxj.gayhub.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // bind vms
        bindViewModel()
        // call initView
        initView()
        // load data
        loadData()
    }

    open fun getLayoutId() = 0
    open fun bindViewModel() {}
    open fun initView() {}
    open fun loadData() {}
}