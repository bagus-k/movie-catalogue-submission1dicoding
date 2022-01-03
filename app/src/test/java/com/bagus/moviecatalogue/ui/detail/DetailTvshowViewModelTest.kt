package com.bagus.moviecatalogue.ui.detail

import com.bagus.moviecatalogue.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailTvshowViewModelTest {
    private lateinit var viewModel: DetailTvshowViewModel
    private val dummyTvshow = DataDummy.generateDummyTvshow()[0]
    private val tvId = dummyTvshow.tvid

    @Before
    fun setUp() {
        viewModel = DetailTvshowViewModel()
        viewModel.setSelectedTvshow(tvId)
    }

    @Test
    fun getTvshow() {
        viewModel.setSelectedTvshow(dummyTvshow.tvid)
        val tvshowEntity = viewModel.getTvshow()
        assertNotNull(tvshowEntity)
        assertEquals(dummyTvshow.tvid, tvshowEntity.tvid)
        assertEquals(dummyTvshow.title, tvshowEntity.title)
        assertEquals(dummyTvshow.releaseDate, tvshowEntity.releaseDate)
        assertEquals(dummyTvshow.poster, tvshowEntity.poster)
        assertEquals(dummyTvshow.desc, tvshowEntity.desc)
    }
}