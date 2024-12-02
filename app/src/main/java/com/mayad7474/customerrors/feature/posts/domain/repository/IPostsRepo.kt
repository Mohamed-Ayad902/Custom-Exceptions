package com.mayad7474.customerrors.feature.posts.domain.repository

import com.mayad7474.customerrors.feature.posts.domain.model.Post

interface IPostsRepo {
    suspend fun getAllPosts(): List<Post>
}