package kr.co.seonguk.application.publicdatause

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.seonguk.application.publicdatause.databinding.RowInfoBinding

class InfoAdapter :ListAdapter<Row, InfoAdapter.InfoViewHolder>(DiffUtilCallback) {

    private lateinit var recyclerviewClick: ItemOnClickListener

    inner class InfoViewHolder(rowInfoBinding: RowInfoBinding):RecyclerView.ViewHolder(rowInfoBinding.root){
        var rowInfoBinding: RowInfoBinding

        init {
            this.rowInfoBinding = rowInfoBinding
            this.rowInfoBinding.root.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        fun bind(row: Row){
            rowInfoBinding.textViewTitle.text = row.STR_NM
            rowInfoBinding.textViewType.text = row.INDUTYPE_NM
            row.REFINE_LOTNO_ADDR
            rowInfoBinding.root.setOnClickListener {
                recyclerviewClick.recyclerviewClickListener(row.STR_NM?:"", row.INDUTYPE_NM?:"", row.REFINE_LOTNO_ADDR?:"")
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowInfoBinding = RowInfoBinding.inflate(layoutInflater, parent, false)
        return InfoViewHolder(rowInfoBinding)
    }


    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.bind(currentList[position])

    }

    interface ItemOnClickListener{
        fun recyclerviewClickListener(title:String, type:String, address:String)
    }

    fun setRecyclerviewClick(recyclerviewClick: ItemOnClickListener){
        this.recyclerviewClick = recyclerviewClick
    }
}

object DiffUtilCallback : DiffUtil.ItemCallback<Row>(){
    override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean {
        return oldItem == newItem
    }

}

