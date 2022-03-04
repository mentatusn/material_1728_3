package com.gb.material_1728_3.view.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gb.material_1728_3.databinding.ActivityRecyclerItemEarthBinding
import com.gb.material_1728_3.databinding.ActivityRecyclerItemHeaderBinding
import com.gb.material_1728_3.databinding.ActivityRecyclerItemMarsBinding

class RecyclerActivityAdapter(
    private val onListItemClickListener: OnListItemClickListener,
    private var data: List<Data>
) : RecyclerView.Adapter<RecyclerActivityAdapter.BaseViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return data[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        if (viewType == TYPE_EARTH) {
            val itemBinding: ActivityRecyclerItemEarthBinding =
                ActivityRecyclerItemEarthBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            return EarthViewHolder(itemBinding.root)
        } else if (viewType == TYPE_MARS) {
            val itemBinding: ActivityRecyclerItemMarsBinding =
                ActivityRecyclerItemMarsBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            return MarsViewHolder(itemBinding.root)
        } else {
            val itemBinding: ActivityRecyclerItemHeaderBinding =
                ActivityRecyclerItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            return HeaderViewHolder(itemBinding.root)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size


    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(data: Data)
    }

    inner class EarthViewHolder(view: View) : BaseViewHolder(view) {
        override fun bind(data: Data) {
            ActivityRecyclerItemEarthBinding.bind(itemView).apply {
                earthImageView.setOnClickListener {
                    onListItemClickListener.onItemClick(data)
                }
            }
        }
    }

    inner class MarsViewHolder(view: View) : BaseViewHolder(view) {
        override fun bind(data: Data) {
            ActivityRecyclerItemMarsBinding.bind(itemView).apply {
                marsImageView.setOnClickListener {
                    onListItemClickListener.onItemClick(data)
                }
            }
        }
    }

    inner class HeaderViewHolder(view: View) : BaseViewHolder(view) {
        override fun bind(data: Data) {
            ActivityRecyclerItemHeaderBinding.bind(itemView).apply {
                header.setOnClickListener {
                    onListItemClickListener.onItemClick(data)
                }
            }
        }
    }
}