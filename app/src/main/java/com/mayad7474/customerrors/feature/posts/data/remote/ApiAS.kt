package com.mayad7474.customerrors.feature.posts.data.remote

import com.mayad7474.customerrors.feature.posts.data.model.PostDto
import retrofit2.http.GET

interface ApiAS {

    @GET(GET_ALL_POSTS)
    suspend fun getAllPosts(): List<PostDto>

    companion object {
        private const val GET_ALL_POSTS = "posts"
    }
}