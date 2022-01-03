package com.bagus.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.bagus.moviecatalogue.data.MovieEntity
import com.bagus.moviecatalogue.utils.DataDummy

class DetailMovieViewModel: ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val moviesEntities = DataDummy.generateDummyMovie()
        for (movieEntity in moviesEntities) {
            if (movieEntity.mid == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }
}