package com.example.myrapp.Pojitos

import com.google.gson.annotations.SerializedName

data class Posts(
	@field:SerializedName("id")
	var id: String="1",

	@field:SerializedName("title")
	var title: String= "nostalgia",

	@field:SerializedName("body")
	var body: String="hola, queria decirles que aprendí mucho durante este proceso",

	@field:SerializedName("userId")
	var userId: String = "2"
)