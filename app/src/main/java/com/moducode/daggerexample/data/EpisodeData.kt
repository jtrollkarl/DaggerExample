package com.moducode.daggerexample.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "fav_episodes")
@Parcelize
data class EpisodeData(
        @field:PrimaryKey
        @field:SerializedName("id")
        @field:Expose
        val id: Int,
        @field:ColumnInfo(name = "url")
        @field:SerializedName("url")
        @field:Expose
        val url: String,
        @field:ColumnInfo(name = "name")
        @field:SerializedName("name")
        @field:Expose
        val name: String,
        @field:ColumnInfo(name = "season")
        @field:SerializedName("season")
        @field:Expose
        val season: Int,
        @field:ColumnInfo(name = "number")
        @field:SerializedName("number")
        @field:Expose
        val number: Int,
        @field:ColumnInfo(name = "airdate")
        @field:SerializedName("airdate")
        @field:Expose
        val airdate: String,
        @field:ColumnInfo(name = "airtime")
        @field:SerializedName("airtime")
        @field:Expose
        val airtime: String,
        @field:ColumnInfo(name = "airstamp")
        @field:SerializedName("airstamp")
        @field:Expose
        val airstamp: String,
        @field:ColumnInfo(name = "runtime")
        @field:SerializedName("runtime")
        @field:Expose
        val runtime: Int,
        @field:ColumnInfo(name = "image")
        @field:SerializedName("image")
        @field:Expose
        val image: Image,
        @field:ColumnInfo(name = "summary")
        @field:SerializedName("summary")
        @field:Expose
        val summary: String,
        @field:ColumnInfo(name = "_links")
        @field:SerializedName("_links")
        @field:Expose
        val links: Links
) : Parcelable

@Parcelize
data class Links(
        @field:SerializedName("self")
        @field:Expose
        val self: Self
) : Parcelable

@Parcelize
data class Self(
        @field:SerializedName("href")
        @field:Expose
        val href: String
) : Parcelable

@Parcelize
data class Image(
        @field:SerializedName("medium")
        @field:Expose
        val medium: String,
        @field:SerializedName("original")
        @field:Expose
        val original: String
) : Parcelable