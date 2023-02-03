package com.example.islami.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.islami.Constents
import com.example.islami.R

class SebhaFragment : Fragment() {

    lateinit var phase : TextView
    lateinit var counterTv : TextView
    var counter : Int= 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counterTv=view.findViewById(R.id.counter_sabha)
        counterTv.text="$counter"
        phase=view.findViewById(R.id.phase)
        phase.setOnClickListener{
            onSebhaClick()
        }
    }

    private fun onSebhaClick() {
        counter++
        counterTv.text="$counter"

        if(phase.text==Constents.KATAMA)    {
            phase.text = Constents.SBAHNALL
            counter=0
            counterTv.text="$counter"
        }

        if(counter==33){
            if(phase.text == Constents.SBAHNALL){
                phase.text= Constents.ALHAMDLLA
                counter =0
                counterTv.text="$counter"
            }
            else if(phase.text == Constents.ALHAMDLLA){
                phase.text = Constents.ALLAKBER
                counter=0
            }
            else if(phase.text == Constents.ALLAKBER){
                phase.text = Constents.KATAMA
                counter=0
                counterTv.text="$counter"
            }
        }
    }

}