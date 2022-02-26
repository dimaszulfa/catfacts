package com.dilatama.cats

import com.dilatama.cats.data.CatFactsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("facts")
    fun getAllCatFacts(): Call<CatFactsResponse>

}