package com.example.project7.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project7.model.PopularMovieResponse
import com.example.project7.model.Result
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

    private val _popularMovies = MutableLiveData<List<Result>>()
    val popularMovies: LiveData<List<Result>> = _popularMovies

    var message: String = ""

    fun executeGetPopularMovies(page: Int) = viewModelScope.launch {
        when (val resource = repo.getPopularMovies(API_KEY, page)) {
            is Resource.Failed -> {
                message = resource.message
//                Log.i("Retrofit", "Error Cuk")

            }
            is Resource.Ok -> {
                message = resource.message
                _popularMovies.value = resource.data!!.results
//                Log.i("Retrofit", "${resource.data}")
            }
        }
    }

//
}