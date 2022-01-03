package com.bagus.moviecatalogue.ui.detail

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bagus.moviecatalogue.databinding.ActivityDetailTvshowBinding

class DetailTvshowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailTvshowBinding = ActivityDetailTvshowBinding.inflate(layoutInflater)
        setContentView(detailTvshowBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvshowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvId = extras.getString(DetailTvshowActivity.EXTRA_TVSHOW)
            if (tvId != null) {
                viewModel.setSelectedTvshow(tvId)
                detailTvshowBinding.imagePoster.setImageResource(getImageId(this,viewModel.getTvshow().poster))
                detailTvshowBinding.textTitle.setText(viewModel.getTvshow().title)
                detailTvshowBinding.textReleaseDate.setText(viewModel.getTvshow().releaseDate)
                detailTvshowBinding.textDescItem.setText(viewModel.getTvshow().desc)
                supportActionBar?.setTitle(viewModel.getTvshow().title)
            }
        }
    }

    fun getImageId(context: Context, imageName: String): Int {
        return context.getResources()
            .getIdentifier("drawable/$imageName", null, context.getPackageName())
    }
}