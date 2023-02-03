package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.OnSuraClickListener
import com.example.islami.R

class SuresNameAdapter(var suras : List<String>, var count: List<String>):
    RecyclerView.Adapter<SuresNameAdapter.SuresNameViewHolder>() {

    var OnSuraClickListener : OnSuraClickListener?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuresNameViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.quran_list_item,parent,false)
        return SuresNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuresNameViewHolder, position: Int) {
      holder.suraName.text= suras.get(position)
        holder.suraContentCount.text=count.get(position)
        holder.itemView.setOnClickListener{
            OnSuraClickListener?.onSuraClick(position,suras.get(position))
        }
    }

    override fun getItemCount(): Int {
        return suras.size
    }
    class SuresNameViewHolder(val itemView : View) : RecyclerView.ViewHolder(itemView){

         val suraName=itemView.findViewById<TextView>(R.id.sura_name)
            val suraContentCount=itemView.findViewById<TextView>(R.id.Num_ayat)
    }



}