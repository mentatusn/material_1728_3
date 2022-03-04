package com.gb.material_1728_3.view.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    lateinit var adapter :RecyclerActivityAdapter
    lateinit var binding: ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = arrayListOf(
            //Data("",type = TYPE_HEADER),
            Pair(ITEM_CLOSE, Data("Earth", type = TYPE_EARTH)),
            Pair(ITEM_CLOSE, Data("Earth", type = TYPE_EARTH)),
            Pair(ITEM_CLOSE, Data("Mars", "", type = TYPE_MARS)),
            Pair(ITEM_CLOSE, Data("Earth", type = TYPE_EARTH)),
            Pair(ITEM_CLOSE, Data("Earth", type = TYPE_EARTH)),
            Pair(ITEM_CLOSE, Data("Earth", type = TYPE_EARTH)),
            Pair(ITEM_CLOSE, Data("Mars", "", type = TYPE_MARS))

        )
        data.add(0,Pair(ITEM_CLOSE, Data("Заголовок", type = TYPE_HEADER)))

        val lat = 23
        val lon = 21
        val pair1 = Pair(lat, lon)
        val pair2 = lat to lon
        val pair3 = Triple(lon, lon, lon)
        pair1.first
        pair1.second

        pair2.first
        pair2.second

        pair3.first
        pair3.second
        pair3.third


        adapter = RecyclerActivityAdapter({
            Toast.makeText(this@RecyclerActivity, it.someText, Toast.LENGTH_SHORT).show()
        }, data)

        binding.recyclerView.adapter = adapter

        binding.recyclerActivityFAB.setOnClickListener {
            adapter.addItem()
            binding.recyclerView.smoothScrollToPosition(adapter.itemCount - 1)
        }

        ItemTouchHelper(ItemTouchHelperCallback(adapter)).attachToRecyclerView(binding.recyclerView)
    }

    class ItemTouchHelperCallback(private val adapter: RecyclerActivityAdapter): ItemTouchHelper.Callback(){

        override fun isLongPressDragEnabled(): Boolean {
            return true
        }

        override fun isItemViewSwipeEnabled(): Boolean {
            return super.isItemViewSwipeEnabled()
        }
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            val drag = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            val swipe = ItemTouchHelper.START or ItemTouchHelper.END
            return makeMovementFlags(drag,swipe)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            adapter.onItemMove(viewHolder.adapterPosition,target.adapterPosition)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            adapter.onItemDismiss(viewHolder.adapterPosition)
        }

        override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
            if (viewHolder !is RecyclerActivityAdapter.MarsViewHolder){
                return super.onSelectedChanged(viewHolder, actionState)
            }
            if(actionState!=ItemTouchHelper.ACTION_STATE_IDLE){
                (viewHolder as ItemTouchHelperViewAdapter).onItemSelected()
            }

        }

        override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {

            if (viewHolder !is RecyclerActivityAdapter.MarsViewHolder){
                return super.clearView(recyclerView, viewHolder)
            }
            (viewHolder as ItemTouchHelperViewAdapter).onItemClear()
            super.clearView(recyclerView, viewHolder)
        }

    }
}