package com.bagus.moviecatalogue.ui.movies

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovies() {
        val moviesEntities = viewModel.getMovies()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities.size)
    }
}