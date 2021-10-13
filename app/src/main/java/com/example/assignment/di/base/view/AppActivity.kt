package com.example.assignment.di.base.view

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import com.example.assignment.di.base.viewmodel.BaseViewModel
import com.example.assignment.di.base.viewmodel.SingleMessageEvent

abstract class AppActivity<B : ViewDataBinding?, V : BaseViewModel?> : BaseActivity<B, V>() {

    @JvmField
    protected val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeBaseEvents()
    }

    private fun subscribeBaseEvents() {
        viewModel!!.normal.observe(this, object : SingleMessageEvent.MessageObserver {
            override fun onMessageReceived(msgResId: Int) {
                Toast.makeText(this@AppActivity, getString(msgResId), Toast.LENGTH_LONG).show()
            }

            override fun onMessageReceived(msg: String) {
                if (!TextUtils.isEmpty(msg)) Toast.makeText(
                    this@AppActivity,
                    msg,
                    Toast.LENGTH_LONG
                ).show()

            }
        })
        viewModel!!.success.observe(this, object : SingleMessageEvent.MessageObserver {
            override fun onMessageReceived(msgResId: Int) {
                Toast.makeText(this@AppActivity, getString(msgResId), Toast.LENGTH_LONG).show()
            }

            override fun onMessageReceived(msg: String) {
                if (!TextUtils.isEmpty(msg)) Toast.makeText(
                    this@AppActivity,
                    msg,
                    Toast.LENGTH_LONG
                ).show()

            }
        })
        viewModel!!.error.observe(this, object : SingleMessageEvent.MessageObserver {
            override fun onMessageReceived(msgResId: Int) {
                Toast.makeText(this@AppActivity, getString(msgResId), Toast.LENGTH_LONG).show()

            }

            override fun onMessageReceived(msg: String) {
                if (!TextUtils.isEmpty(msg)) Toast.makeText(
                    this@AppActivity,
                    msg,
                    Toast.LENGTH_LONG
                ).show()

            }
        })
        viewModel!!.warn.observe(this, object : SingleMessageEvent.MessageObserver {
            override fun onMessageReceived(msgResId: Int) {
                Toast.makeText(this@AppActivity, getString(msgResId), Toast.LENGTH_LONG).show()

            }

            override fun onMessageReceived(msg: String) {
                if (!TextUtils.isEmpty(msg)) Toast.makeText(
                    this@AppActivity,
                    msg,
                    Toast.LENGTH_LONG
                ).show()

            }
        })
        viewModel!!.info.observe(this, object : SingleMessageEvent.MessageObserver {
            override fun onMessageReceived(msgResId: Int) {
                Toast.makeText(this@AppActivity, getString(msgResId), Toast.LENGTH_LONG).show()

            }

            override fun onMessageReceived(msg: String) {
                if (!TextUtils.isEmpty(msg)) Toast.makeText(
                    this@AppActivity,
                    msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        })

    }

    protected open fun onInternetRefresh(isConnected: Boolean) {}


}