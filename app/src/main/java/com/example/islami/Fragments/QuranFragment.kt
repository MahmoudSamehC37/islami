package com.example.islami.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.*
import com.example.islami.Activities.SuraDetailsActivity
import com.example.islami.Adapters.SuresNameAdapter
import com.example.islami.DataClasses.ArSuras
import com.example.islami.DataClasses.ayatNumber


class QuranFragment : Fragment() {

        lateinit var quranRecyclerView : RecyclerView
        lateinit var quranAdapter : SuresNameAdapter
        lateinit var switchModeButton : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranRecyclerView=view.findViewById(R.id.quran_recyclerview)
        switchModeButton=view.findViewById(R.id.switch_mode)

        SwitchModeLogic()

        quranAdapter= SuresNameAdapter(ArSuras, ayatNumber)
        quranRecyclerView.adapter=quranAdapter
        quranAdapter.OnSuraClickListener= object : OnSuraClickListener {
            override fun onSuraClick(position: Int,suraName : String) {
                var intent1= Intent(requireActivity(), SuraDetailsActivity::class.java)
                intent1.putExtra(Constents.EXTRA_SURA_POSITION,position)
                intent1.putExtra(Constents.EXTRA_SURA_NAME_KAY,suraName)
                startActivity(intent1)
            }
        }

    }
    fun SwitchModeLogic(){
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            switchModeButton.text="Ligth"
        }else{
            switchModeButton.text="Dark"
        }
        switchModeButton.setOnClickListener{
            if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switchModeButton.text="Dark"
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switchModeButton.text="Ligth"
            }
        }
    }


}

