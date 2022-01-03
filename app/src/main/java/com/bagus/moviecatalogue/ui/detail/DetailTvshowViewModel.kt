package com.bagus.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.bagus.moviecatalogue.data.TvshowEntity
import com.bagus.moviecatalogue.utils.DataDummy

class DetailTvshowViewModel: ViewModel() {
    private lateinit var tvId: String

    fun setSelectedTvshow(tvId: String) {
        this.tvId = tvId
    }

    fun getTvshow(): TvshowEntity {
        lateinit var tvshow: TvshowEntity
        val tvshowEntities = DataDummy.generateDummyTvshow()
        for (tvshowEntity in tvshowEntities) {
            if (tvshowEntity.tvid == tvId) {
                tvshow = tvshowEntity
            }
        }
        return tvshow
    }
}