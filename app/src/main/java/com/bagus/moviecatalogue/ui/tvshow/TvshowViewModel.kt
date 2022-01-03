package com.bagus.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.bagus.moviecatalogue.data.TvshowEntity
import com.bagus.moviecatalogue.utils.DataDummy

class TvshowViewModel: ViewModel() {
    fun getTvshow(): List<TvshowEntity> = DataDummy.generateDummyTvshow()
}