package com.mayad7474.customerrors.feature.posts.presentation.state

import com.mayad7474.customerrors.android.exceptions.CustomException
import com.mayad7474.customerrors.feature.posts.domain.model.Post

sealed class MainState {
    data class Loading(val isLoading: Boolean) : MainState()
    data class Success(val posts: List<Post>) : MainState()
    data class Error(val error: CustomException) : MainState()
}

sealed class MainIntent {
    data object LoadPosts : MainIntent()
}