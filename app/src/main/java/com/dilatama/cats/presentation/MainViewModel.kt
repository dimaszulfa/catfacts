package com.dilatama.cats.presentation

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dilatama.cats.ApiConfig
import com.dilatama.cats.data.CatFactsResponse
import com.dilatama.cats.data.DataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel() : ViewModel() {
    private val _catfacts = MutableLiveData<List<DataItem>>()
    val catfacts: LiveData<List<DataItem>> = _catfacts
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object {
        private const val TAG = "MainViewModel"
    }

    init {
        addFact()
    }

    fun addFact() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getAllCatFacts()
        client.enqueue(object: Callback<CatFactsResponse> {
            override fun onResponse(
                call: Call<CatFactsResponse>,
                response: Response<CatFactsResponse>
            ) {
                _isLoading.value = false
                if(response.isSuccessful){
                    _catfacts.value = response.body()?.data
                }else{
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<CatFactsResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}