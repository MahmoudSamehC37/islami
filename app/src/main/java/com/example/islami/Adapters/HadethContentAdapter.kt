package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class HadethContentAdapter(var hadethLines : List<String?>?):
RecyclerView.Adapter<HadethContentAdapter.HadethContentViewHolder>(){



    class HadethContentViewHolder(val itemView : View):
        RecyclerView.ViewHolder(itemView){
        val HadethLineText: TextView
        init {
            HadethLineText=itemView.findViewById(R.id.hadeth_line_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethContentViewHolder {
        val LayoutInflater=LayoutInflater.from(parent.context)
        val view=LayoutInflater.inflate(R.layout.item_hadeth_line,parent,false)
        return HadethContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: HadethContentViewHolder, position: Int) {
        holder.HadethLineText.text=hadethLines?.get(position)
    }

    override fun getItemCount(): Int {
        return hadethLines?.size?:0
    }

    fun updataData(hadethLines : List<String?>?){
        this.hadethLines=hadethLines
        notifyDataSetChanged()
    }


}