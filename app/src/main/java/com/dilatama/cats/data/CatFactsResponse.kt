package com.dilatama.cats.data

import com.google.gson.annotations.SerializedName

data class CatFactsResponse(

	@field:SerializedName("per_page")
	val perPage: Int,

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("last_page")
	val lastPage: Int,

	@field:SerializedName("next_page_url")
	val nextPageUrl: String,

	@field:SerializedName("prev_page_url")
	val prevPageUrl: Any,

	@field:SerializedName("first_page_url")
	val firstPageUrl: String,

	@field:SerializedName("path")
	val path: String,

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("last_page_url")
	val lastPageUrl: String,

	@field:SerializedName("from")
	val from: Int,

	@field:SerializedName("links")
	val links: List<LinksItem>,

	@field:SerializedName("to")
	val to: Int,

	@field:SerializedName("current_page")
	val currentPage: Int
)

data class DataItem(

	@field:SerializedName("fact")
	val fact: String,

	@field:SerializedName("length")
	val length: Int
)

data class LinksItem(

	@field:SerializedName("active")
	val active: Boolean,

	@field:SerializedName("label")
	val label: String,

	@field:SerializedName("url")
	val url: Any
)
