package com.mayad7474.customerrors.di

import com.mayad7474.customerrors.feature.posts.data.remote.ApiAS
import com.mayad7474.customerrors.feature.posts.domain.repository.IPostsRepo
import com.mayad7474.customerrors.feature.posts.data.repository.PostsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePostsRepository(api: ApiAS): IPostsRepo = PostsRepo(api)

}
