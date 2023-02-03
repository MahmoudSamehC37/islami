package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class SuraContentAdapter(var suraLines : List<String?>?)
    :RecyclerView.Adapter<SuraContentAdapter.SuraContentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraContentViewHolder {
        val LayoutInflater=LayoutInflater.from(parent.context)
        val view=LayoutInflater.inflate(R.layout.item_sura_line,parent,false)
        return SuraContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuraContentViewHolder, position: Int) {
        holder.suraLineText.text=suraLines?.get(position)
    }

    override fun getItemCount(): Int {
        return suraLines?.size?:0
    }

    fun updataData(suraLines : List<String?>?){
        this.suraLines=suraLines
        notifyDataSetChanged()
    }
    class SuraContentViewHolder(val itemView : View):RecyclerView.ViewHolder(itemView){
        val suraLineText: TextView

        init {
            suraLineText=itemView.findViewById(R.id.sura_line_text)
        }
    }


}