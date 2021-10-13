package com.example.assignment.ui.home

import com.example.assignment.data.beans.Data
import com.example.assignment.data.remote.helper.ApiCallback
import com.example.assignment.data.remote.helper.NetworkErrorHandler
import com.example.assignment.data.remote.helper.Resource
import com.example.assignment.data.repo.dash.DashRepo
import com.example.assignment.di.base.viewmodel.BaseViewModel
import com.example.assignment.di.base.viewmodel.SingleRequestEvent
import retrofit2.Response
import javax.inject.Inject

class MainActivityVM @Inject constructor(
    private val dashRepo: DashRepo,
    private val networkErrorHandler: NetworkErrorHandler
) : BaseViewModel() {

    val obrUserInfo = SingleRequestEvent<Data>()

        fun getTopRatedList(page: Int) {
        dashRepo.getTopRatedListAsync(1, object : ApiCallback<Response<Data>>() {
            override fun onSuccess(response: Response<Data>) {
                obrUserInfo.value = Resource.success(response.body(), "Ok")
            }

            override fun onFailed(message: String) {
                obrUserInfo.value = Resource.error(null, message)
            }

            override fun onErrorThrow(exception: Exception) {
                obrUserInfo.value = Resource.error(null, networkErrorHandler.getErrMsg(exception))
            }

            override fun onLoading() {
                obrUserInfo.value = Resource.loading(null, "")
            }
        })
    }
}