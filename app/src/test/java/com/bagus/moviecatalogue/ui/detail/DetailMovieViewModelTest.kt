package com.bagus.moviecatalogue.ui.detail

import com.bagus.moviecatalogue.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.mid

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.mid)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.mid, movieEntity.mid)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.poster, movieEntity.poster)
        assertEquals(dummyMovie.desc, movieEntity.desc)
    }
}