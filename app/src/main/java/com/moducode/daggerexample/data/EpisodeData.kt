package com.moducode.daggerexample.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class EpisodeData(
        @field:SerializedName("id")
        @field:Expose
        val id: Int,
        @field:SerializedName("url")
        @field:Expose
        val url: String,
        @field:SerializedName("name")
        @field:Expose
        val name: String,
        @field:SerializedName("season")
        @field:Expose
        val season: Int,
        @field:SerializedName("number")
        @field:Expose
        val number: Int,
        @field:SerializedName("airdate")
        @field:Expose
        val airdate: String,
        @field:SerializedName("airtime")
        @field:Expose
        val airtime: String,
        @field:SerializedName("airstamp")
        @field:Expose
        val airstamp: String,
        @field:SerializedName("runtime")
        @field:Expose
        val runtime: Int,
        @field:SerializedName("image")
        @field:Expose
        val image: Image,
        @field:SerializedName("summary")
        @field:Expose
        val summary: String,
        @field:SerializedName("_links")
        @field:Expose
        val links: Links
)

data class Links(
        @field:SerializedName("self")
        @field:Expose
        val self: Self
)

data class Self(
        @field:SerializedName("href")
        @field:Expose
        val href: String
)

data class Image(
        @field:SerializedName("medium")
        @field:Expose
        val medium: String,
        @field:SerializedName("original")
        @field:Expose
        val original: String
)