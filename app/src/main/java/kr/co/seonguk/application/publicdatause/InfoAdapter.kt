package kr.co.seonguk.application.publicdatause

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.seonguk.application.publicdatause.databinding.RowInfoBinding

class InfoAdapter():RecyclerView.Adapter<InfoViewHolder>() {

    private lateinit var recyclerviewClick: ItemOnClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        val rowInfoBinding = RowInfoBinding.inflate(layoutInflater)
        val viewHolder = InfoViewHolder(rowInfoBinding)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.rowInfoBinding.textViewTitle.text = "우돈가"
        holder.rowInfoBinding.textViewType.text = "일반 음식점"
        holder.rowInfoBinding.root.setOnClickListener {
            recyclerviewClick.recyclerviewClickListener()
        }

    }

    fun submitList(){
        notifyDataSetChanged()
    }

    interface ItemOnClickListener{
        fun recyclerviewClickListener()
    }

    fun setRecyclerviewClick(recyclerviewClick: ItemOnClickListener){
        this.recyclerviewClick = recyclerviewClick
    }
}


class InfoViewHolder(rowInfoBinding: RowInfoBinding):RecyclerView.ViewHolder(rowInfoBinding.root){
    var rowInfoBinding: RowInfoBinding

    init {
        this.rowInfoBinding = rowInfoBinding
        this.rowInfoBinding.root.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}

