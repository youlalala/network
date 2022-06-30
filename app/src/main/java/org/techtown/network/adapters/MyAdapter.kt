package org.techtown.network.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.network.databinding.ItemRecyclerview1Binding
import org.techtown.network.databinding.ItemRecyclerview2Binding
import org.techtown.network.model.ValueModel

class MyAdapter(
    private val jokeList: List<ValueModel>,
    val onClickItem: (valueModel :ValueModel)-> Unit
)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun getItemCount(): Int{
        return jokeList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        if(viewType==1){
            return MyViewHolder1(
                ItemRecyclerview1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }else{
            return MyViewHolder2(
                ItemRecyclerview2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == 1){
            val binding=(holder as MyViewHolder1).binding
            binding.itemId.text = jokeList[position].id
            binding.itemJoke.text = jokeList[position].joke
        }else{
            val binding=(holder as MyViewHolder2).binding
            binding.itemId.text = jokeList[position].id
            binding.itemJoke.text = jokeList[position].joke
        }
        holder.itemView.setOnClickListener {
            onClickItem.invoke(jokeList[position])
        }

    }
}

class MyViewHolder1(val binding: ItemRecyclerview1Binding): RecyclerView.ViewHolder(binding.root)
class MyViewHolder2(val binding: ItemRecyclerview2Binding): RecyclerView.ViewHolder(binding.root)

