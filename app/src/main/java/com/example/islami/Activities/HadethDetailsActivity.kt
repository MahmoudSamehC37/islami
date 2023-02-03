package com.example.islami.Activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Adapters.HadethContentAdapter
import com.example.islami.Constents
import com.example.islami.R

class HadethDetailsActivity : AppCompatActivity() {

    lateinit var hadethContentRecyclerView : RecyclerView
    lateinit var adapter : HadethContentAdapter
    lateinit var hadetNameTextView : TextView
    lateinit var backIcon : ImageView
    var hadethPosition :  Int=0
    var hadethName : String?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        hadethContentRecyclerView=findViewById(R.id.hadeth_content_recyclerview)
        adapter= HadethContentAdapter(null)
        hadethName=intent.getStringExtra(Constents.EXTRA_HADETH_NAME_KAY)
        hadethPosition=intent.getIntExtra(Constents.EXTRA_HADETH_POSITION,0)
        hadethContentRecyclerView.adapter=adapter
        readFileText(hadethPosition)
        hadetNameTextView=findViewById(R.id.hadeths_name)
        backIcon=findViewById(R.id.back_icon)
        hadetNameTextView.text=hadethName
        backIcon.setOnClickListener{
            finish()
        }
    }
    fun readFileText(position:Int){
      //val fileName = "${hadethPosition?.plus(1)}.txt"
        val fileContent: String = assets.open("ahadeth.txt")
            .bufferedReader()
            .use { it.readText() }
        val ahadethList = fileContent.split('#')
        val hadethContent=ahadethList[position]
        val hadethLines=hadethContent.split('\n')
        adapter.updataData(hadethLines)
    }
}