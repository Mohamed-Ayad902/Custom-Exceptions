package com.mayad7474.customerrors.feature.posts.domain.model

data class Post(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
)