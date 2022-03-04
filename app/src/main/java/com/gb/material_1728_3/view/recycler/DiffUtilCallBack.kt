package com.gb.material_1728_3.view.recycler

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallBack(
    private val oldItems: List<Pair<Int, Data>>,
    private val newItems: List<Pair<Int, Data>>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItems[oldItemPosition].second.id == newItems[newItemPosition].second.id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItems[oldItemPosition].second.someText == newItems[newItemPosition].second.someText
                && oldItems[oldItemPosition].second.description == newItems[newItemPosition].second.description


    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any {
        return Change(oldItems[oldItemPosition],newItems[newItemPosition])
    }
}