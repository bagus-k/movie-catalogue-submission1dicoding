package com.bagus.moviecatalogue.ui.detail

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bagus.moviecatalogue.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailMovieBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                detailMovieBinding.imagePoster.setImageResource(getImageId(this,viewModel.getMovie().poster))
                detailMovieBinding.textTitle.setText(viewModel.getMovie().title)
                detailMovieBinding.textReleaseDate.setText(viewModel.getMovie().releaseDate)
                detailMovieBinding.textDescItem.setText(viewModel.getMovie().desc)
                supportActionBar?.setTitle(viewModel.getMovie().title)
            }
        }
    }

    fun getImageId(context: Context, imageName: String): Int {
        return context.getResources()
            .getIdentifier("drawable/$imageName", null, context.getPackageName())
    }
}