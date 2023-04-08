package com.example.newrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_view.view.*

class BuahAdapter(var items : ArrayList<Buah>, var clickListner: OnBuahItemClickListner) : RecyclerView.Adapter<BuahViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuahViewHolder {
        lateinit var buahViewHolder : BuahViewHolder
        buahViewHolder = BuahViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view,parent,false ))
        return buahViewHolder
    }

    override fun onBindViewHolder(holder: BuahViewHolder, position: Int) {
//        holder.buahName?.text =  items.get(position).name
//        holder.buahDescription?.text = items.get(position).description
//        holder.buahLogo.setImageResource(items.get(position).logo)
        holder.initialize(items.get(position),clickListner)

    }
}

class BuahViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    var buahName = itemView.buahname
    var buahDescription = itemView.buahdescription
    var buahLogo = itemView.buahlogo

    fun initialize(item: Buah, action:OnBuahItemClickListner){
        buahName.text = item.name
        buahDescription.text = item.description
        buahLogo.setImageResource(item.logo)

        itemView.setOnClickListener{
            action.onItemClick(item,adapterPosition)
        }

    }

}

interface OnBuahItemClickListner{
    fun onItemClick(item: Buah, position: Int)
}