package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class LoginScreen : Fragment() {

    private lateinit var mProfileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mProfileViewModel= ViewModelProvider(this).get(ProfileViewModel::class.java)


        val view = inflater.inflate(R.layout.fragment_login_screen, container, false)

        val buttonIntroduction=view.findViewById<Button>(R.id.weiterZuIntroductionLoginButton)
        val buttonAnalysis1=view.findViewById<Button>(R.id.weiterZuAnalysisLoginButton)
        val submitButton= view.findViewById<Button>(R.id.submitButton1)

        mProfileViewModel= ViewModelProvider(this).get(ProfileViewModel::class.java)






        buttonIntroduction.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_introduction)
        }

        buttonAnalysis1.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_analysis1)
        }

        submitButton.setOnClickListener {
            insertDatatoDatabase()
            LoadData()
        }

        return view
    }

    private fun insertDatatoDatabase() {
        val name = view?.findViewById<EditText>(R.id.editNametext)?.text.toString()
        if(name!==null){
            val profile= Profile(0,name,null,null)
            mProfileViewModel.createProfile(profile)
            Toast.makeText(requireContext(),"hat Funktioniert!",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(),"bitte Namen eingeben!",Toast.LENGTH_LONG).show()
        }
    }
    private fun LoadData(){
        val data = requireView().findViewById<TextView>(R.id.InputNameRequestText)

        mProfileViewModel.readData.observe(viewLifecycleOwner, Observer{ profil ->
            data.text = profil.toString()

        })

    }


}