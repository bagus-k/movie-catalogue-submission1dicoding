package com.bagus.moviecatalogue.ui.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagus.moviecatalogue.data.MovieEntity
import com.bagus.moviecatalogue.databinding.ItemsMoviesBinding
import com.bagus.moviecatalogue.ui.detail.DetailMovieActivity

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.MoviesViewHolder {
        val itemsMoviesBinding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    class MoviesViewHolder(private val binding: ItemsMoviesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieEntity) {
            with(binding){
                imgPoster.setImageResource(getImageId(binding.imgPoster.context ,movie.poster))
                tvItemTitle.text = movie.title
                tvReleaseDate.text = movie.releaseDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.mid)
                    itemView.context.startActivity(intent)
                }
            }
        }

        fun getImageId(context: Context, imageName: String): Int {
            return context.getResources()
                .getIdentifier("drawable/$imageName", null, context.getPackageName())
        }
    }

}