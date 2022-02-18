package com.example.project7

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project7.repository.MovieRepository
import com.example.util.Constants.API_KEY
import com.example.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repo: MovieRepository
) : ViewModel() {

    fun executeGetPopularMovies(page: Int) = viewModelScope.launch {
        when (val resource = repo.getPopularMovies(API_KEY, page)) {
            is Resource.Failed -> {
                Log.i("Retrofit", "Error Cuk")
            }
            is Resource.Ok -> {
                Log.i("Retrofit", "${resource.data}")
            }
        }
    }
}