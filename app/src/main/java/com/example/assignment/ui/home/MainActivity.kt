package com.example.assignment.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.assignment.R
import com.example.assignment.data.remote.helper.Status
import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.di.base.view.AppActivity
import com.example.assignment.di.base.viewmodel.SingleRequestEvent

class MainActivity : AppActivity<ActivityMainBinding, MainActivityVM>() {

    fun newIntent(context: Context): Intent {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        return intent
    }


    override fun getBindingActivity(): BindingActivity<MainActivityVM> {
        return BindingActivity(R.layout.activity_main, MainActivityVM::class.java)

    }

    override fun subscribeToEvents(vm: MainActivityVM?) {
        Log.e(">>>>", "subscribeToEvents: ")
        viewModel.obrUserInfo.observe(this, SingleRequestEvent.RequestObserver { resource ->
            when (resource.status) {
                Status.LOADING -> {
                    showProgressDialog(R.string.plz_wait)
                }
                Status.SUCCESS -> {
                    Log.e(">>>>", "subscribeToEvents: " + resource.data.results?.size)
                    Log.e(">>>>", "subscribeToEvents: " + resource.data.results?.size)
                    dismissProgressDialog()
                }
                Status.WARN -> {
                    dismissProgressDialog()
                    viewModel.warn.value = resource.message
                }
                Status.ERROR -> {
                    dismissProgressDialog()
                    viewModel.error.value = resource.message
                }
            }
        })
        vm?.getTopRatedList(1)
    }


}