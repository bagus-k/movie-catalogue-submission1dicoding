package com.bagus.moviecatalogue.ui.tvshow

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagus.moviecatalogue.data.TvshowEntity
import com.bagus.moviecatalogue.databinding.ItemsTvshowBinding
import com.bagus.moviecatalogue.ui.detail.DetailTvshowActivity

class TvshowAdapter : RecyclerView.Adapter<TvshowAdapter.TvshowViewHolder>() {

    private var listTvshow= ArrayList<TvshowEntity>()

    fun setTvshow(tvshow: List<TvshowEntity>?) {
        if (tvshow == null) return
        this.listTvshow.clear()
        this.listTvshow.addAll(tvshow)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvshowAdapter.TvshowViewHolder {
        val itemsTvshowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvshowViewHolder(itemsTvshowBinding)
    }

    override fun onBindViewHolder(holder: TvshowViewHolder, position: Int) {
        val tvshow = listTvshow[position]
        holder.bind(tvshow)
    }

    override fun getItemCount(): Int {
        return listTvshow.size
    }

    class TvshowViewHolder(private val binding: ItemsTvshowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvshow: TvshowEntity) {
            with(binding){
                imgPoster.setImageResource(getImageId(binding.imgPoster.context ,tvshow.poster))
                tvItemTitle.text = tvshow.title
                tvReleaseDate.text = tvshow.releaseDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvshowActivity::class.java)
                    intent.putExtra(DetailTvshowActivity.EXTRA_TVSHOW, tvshow.tvid)
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