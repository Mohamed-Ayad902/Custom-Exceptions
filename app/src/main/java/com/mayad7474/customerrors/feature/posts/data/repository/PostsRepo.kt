package com.mayad7474.customerrors.feature.posts.data.repository

import com.mayad7474.customerrors.feature.posts.data.remote.ApiAS
import com.mayad7474.customerrors.feature.posts.data.model.PostMapper
import com.mayad7474.customerrors.feature.posts.domain.model.Post
import com.mayad7474.customerrors.feature.posts.domain.repository.IPostsRepo
import javax.inject.Inject

class PostsRepo @Inject constructor(private val api: ApiAS) : IPostsRepo {

    override suspend fun getAllPosts(): List<Post> {
        return api.getAllPosts().map { PostMapper.mapToDomain(it) }
    }

}