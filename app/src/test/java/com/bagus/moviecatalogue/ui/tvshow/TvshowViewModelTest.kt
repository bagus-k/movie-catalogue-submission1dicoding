package com.bagus.moviecatalogue.ui.tvshow

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TvshowViewModelTest {

    private lateinit var viewModel: TvshowViewModel

    @Before
    fun setUp() {
        viewModel = TvshowViewModel()
    }

    @Test
    fun getTvshow() {
        val tvshowEntities = viewModel.getTvshow()
        assertNotNull(tvshowEntities)
        assertEquals(10, tvshowEntities.size)
    }
}