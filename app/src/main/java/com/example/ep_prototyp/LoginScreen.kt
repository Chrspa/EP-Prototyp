package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R

class LoginScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login_screen, container, false)

        val buttonIntroduction=view.findViewById<Button>(R.id.weiterZuIntroductionLoginButton)

        buttonIntroduction.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_introduction)
        }
        val buttonAnalysis1=view.findViewById<Button>(R.id.weiterZuAnalysisLoginButton)

        buttonAnalysis1.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_analysis1)
        }



        return view
    }



}