package org.techtown.network.recycle


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.network.databinding.ItemRecyclerviewBinding
import org.techtown.network.model.ValueModel

class MyAdapter(
    private val jokeList: List<ValueModel>,
    val onClickItem: (valueModel :ValueModel)-> Unit)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun getItemCount(): Int{
        return jokeList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyViewHolder).binding

        binding.itemId.text = jokeList[position].id
        binding.itemJoke.text = jokeList[position].joke

        holder.itemView.setOnClickListener {
            onClickItem.invoke(jokeList[position])
        }

    }


}