package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class StartFrame : Fragment() {
    private lateinit var mProfileDatabase : ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_start_frame, container, false)
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            mProfileDatabase.readData.observe(viewLifecycleOwner, Observer { rezept ->
              if(rezept[0].PracticeViewFlag==1){
                  findNavController().navigate(R.id.action_startFrame_to_practice2)

              }else{
                  findNavController().navigate(R.id.action_startFrame_to_loginScreen)
              }
            })
        }

    return view
    }




}