package com.mayad7474.customerrors.feature.posts.data.model

import com.mayad7474.customerrors.utils.IBaseMapper
import com.mayad7474.customerrors.feature.posts.domain.model.Post

object PostMapper : IBaseMapper<PostDto, Post> {
    override fun mapToDomain(dto: PostDto) =
        Post(id = dto.id, userId = dto.userId, title = dto.title, body = dto.body)

    override fun mapToDto(domain: Post) =
        PostDto(userId = domain.userId, id = domain.id, title = domain.title, body = domain.body)
}