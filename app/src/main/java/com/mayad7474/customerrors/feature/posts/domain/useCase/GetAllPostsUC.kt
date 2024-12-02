package com.mayad7474.customerrors.feature.posts.domain.useCase

import com.mayad7474.customerrors.feature.posts.domain.repository.IPostsRepo
import com.mayad7474.customerrors.core.interactor.safeCallAsFlow
import javax.inject.Inject

class GetAllPostsUC @Inject constructor(private val repo: IPostsRepo) {

    fun execute() = safeCallAsFlow { repo.getAllPosts() }

}