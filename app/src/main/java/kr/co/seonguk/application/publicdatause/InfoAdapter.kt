package kr.co.seonguk.application.publicdatause

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
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowInfoBinding = RowInfoBinding.inflate(layoutInflater, parent, false)
        return InfoViewHolder(rowInfoBinding)
    }


    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.bind(currentList[position])
        holder.rowInfoBinding.root.setOnClickListener {
            recyclerviewClick.recyclerviewClickListener()
        }

    }

    interface ItemOnClickListener{
        fun recyclerviewClickListener()
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

