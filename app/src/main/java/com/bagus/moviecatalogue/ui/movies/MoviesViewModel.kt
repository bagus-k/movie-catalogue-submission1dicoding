package com.bagus.moviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.bagus.moviecatalogue.data.MovieEntity
import com.bagus.moviecatalogue.utils.DataDummy

class MoviesViewModel: ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovie()
}