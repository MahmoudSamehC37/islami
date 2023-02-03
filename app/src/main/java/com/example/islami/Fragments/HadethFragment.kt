package com.example.islami.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Activities.HadethDetailsActivity
import com.example.islami.Adapters.HadethNameAdapter
import com.example.islami.Adapters.SuresNameAdapter
import com.example.islami.Constents
import com.example.islami.DataClasses.ArHadths
import com.example.islami.DataClasses.ArSuras
import com.example.islami.DataClasses.Hadeth
import com.example.islami.DataClasses.ayatNumber
import com.example.islami.OnHadethClickListener
import com.example.islami.R


class HadethFragment : Fragment() {

    lateinit var hadethRecyclerView : RecyclerView
   lateinit var hadethAdapter : HadethNameAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    lateinit var adapter: HadethNameAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hadethRecyclerView=view.findViewById(R.id.hadeth_recycler_view)
        hadethAdapter= HadethNameAdapter(ArHadths)
        hadethRecyclerView.adapter=hadethAdapter
        hadethAdapter.OnHadethClickListener= object : OnHadethClickListener {
            override fun onHadethClick(position: Int,hadethName : String) {
                var intent1= Intent(requireActivity(), HadethDetailsActivity::class.java)
                intent1.putExtra(Constents.EXTRA_HADETH_POSITION,position)
                intent1.putExtra(Constents.EXTRA_HADETH_NAME_KAY,hadethName)
                startActivity(intent1)
            }
        }

    }





}