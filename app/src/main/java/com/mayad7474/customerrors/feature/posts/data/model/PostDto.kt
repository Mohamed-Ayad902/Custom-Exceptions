package com.mayad7474.customerrors.feature.posts.data.model

import com.google.gson.annotations.SerializedName

data class PostDto(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
)