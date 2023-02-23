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

    private lateinit var mProfileDatabase:ProfileViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login_screen, container, false)

        //UserViewModel
        mProfileDatabase=ViewModelProvider(this).get(ProfileViewModel::class.java)

        val username=view.findViewById<EditText>(R.id.editNametext)
        loadData(username)

        val buttonIntroduction=view.findViewById<Button>(R.id.weiterZuIntroductionLoginButton)

        buttonIntroduction.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_introduction)
        }
        val buttonAnalysis1=view.findViewById<Button>(R.id.weiterZuAnalysisLoginButton)

        buttonAnalysis1.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_analysis1)
        }

        val submitButton = view.findViewById<Button>(R.id.submitButton1)


        submitButton.setOnClickListener(){
            val editName = view.findViewById<EditText>(R.id.editNametext).text.toString()
            val feedback = requireView().findViewById<TextView>(R.id.feedbackText)
            if (editName == "Name" || editName == ""){
                feedback.text = "Bitte gib einen Namen ein."
            }else{ UpdateProfile(editName,feedback)}
        }
        return view
    }

    private fun loadData(username:EditText){
        mProfileDatabase.readData.observe(viewLifecycleOwner, Observer { profil ->
            username.setText(profil[0].name)
        })
    }
    private fun UpdateProfile(editName:String,feedback:TextView){
            mProfileDatabase.readData.observe(viewLifecycleOwner, Observer { profil ->
                if(profil.isEmpty()){
                    mProfileDatabase.createProfile(Profile(0,editName))
                }else {
                    mProfileDatabase.updateProfile(Profile(1, editName, profil[0].notificationZeit, profil[0].goal))
                }
            })
            Toast.makeText(requireContext(),"Neuer Name aktualisiert!",Toast.LENGTH_SHORT).show()
            feedback.text="Hallo $editName! Schön das du da bist!"


    }


    }



