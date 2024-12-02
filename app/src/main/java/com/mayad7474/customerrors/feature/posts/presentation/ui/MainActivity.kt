package com.mayad7474.customerrors.feature.posts.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mayad7474.customerrors.android.extensions.collect
import com.mayad7474.customerrors.databinding.ActivityMainBinding
import com.mayad7474.customerrors.feature.posts.presentation.state.MainIntent
import com.mayad7474.customerrors.feature.posts.presentation.state.MainState
import com.mayad7474.customerrors.feature.posts.presentation.viewModels.MainVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainVM by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        userIntents()
        collectState()
    }

    private fun userIntents() {
        binding.btnGetPosts.setOnClickListener {
            viewModel.processIntent(MainIntent.LoadPosts)
        }
    }

    private fun collectState() {
        viewModel.state.collect(this) { state ->
            Log.w("collectingState", state.toString())
            when (state) {
                is MainState.Loading -> binding.progressBar.show(state.isLoading)
                is MainState.Success -> binding.tvPostsContent.text = state.posts.toString()
                is MainState.Error -> {
                    // Here we have the domain level error, we can check for it and decide action related to it
                    // For simplicity we just show toast and log it
                    Toast.makeText(this, state.error.msg, Toast.LENGTH_SHORT).show()
                    Log.e("MainActivity", "collectState: ${state.error}")
                }
            }
        }
    }

}

fun View.show(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}