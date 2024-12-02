package com.mayad7474.customerrors.feature.posts.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayad7474.customerrors.feature.posts.domain.useCase.GetAllPostsUC
import com.mayad7474.customerrors.core.interactor.Resource
import com.mayad7474.customerrors.feature.posts.presentation.state.MainIntent
import com.mayad7474.customerrors.feature.posts.presentation.state.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val getAllPostsUC: GetAllPostsUC
) : ViewModel() {

    private val _state = MutableStateFlow<MainState>(MainState.Loading(false))
    val state: StateFlow<MainState> = _state.asStateFlow()

    fun processIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.LoadPosts -> getAllPosts()
        }
    }

    private fun getAllPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllPostsUC.execute().collect { result ->
                when (result) {
                    is Resource.Loading -> _state.value = MainState.Loading(result.loading)
                    is Resource.Success -> _state.value = MainState.Success(result.data)
                    is Resource.Error -> {
                        _state.value = MainState.Error(result.exception)
                    }
                }
            }
        }
    }

}
