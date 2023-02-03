package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.OnHadethClickListener
import com.example.islami.OnSuraClickListener
import com.example.islami.R

class HadethNameAdapter(var hadeths : List<String>):
RecyclerView.Adapter<HadethNameAdapter.HadethsNameViewHolder>(){

    var OnHadethClickListener : OnHadethClickListener?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethsNameViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.hadeth_list_item,parent,false)
        return HadethsNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: HadethsNameViewHolder, position: Int) {
        holder.hadethName.text= hadeths.get(position)
        holder.itemView.setOnClickListener{
            OnHadethClickListener?.onHadethClick(position,hadeths.get(position))
        }

    }

    override fun getItemCount(): Int {
        return hadeths.size
    }
    class HadethsNameViewHolder(val itemView : View) : RecyclerView.ViewHolder(itemView){

        val hadethName=itemView.findViewById<TextView>(R.id.hadeth_name)
    }


}