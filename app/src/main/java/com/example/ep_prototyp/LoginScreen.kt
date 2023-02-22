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







        buttonIntroduction.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_introduction)
        }

        buttonAnalysis1.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_analysis1)
        }

        submitButton.setOnClickListener {
          //  addBehaviour()
            delete()
            loadBehaviour()

        }

        return view
    }

    private fun insertDatatoDatabase() {
        val name = view?.findViewById<EditText>(R.id.editNametext)?.text.toString()
        if(name.length>1){

            mProfileViewModel.createProfile(Profile(0,name))
            Toast.makeText(requireContext(),"hat Funktioniert!",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(),"bitte Namen eingeben!",Toast.LENGTH_LONG).show()
        }
    }
    private fun loadData(){
        val data = requireView().findViewById<TextView>(R.id.InputNameRequestText)

        mProfileViewModel.readData.observe(viewLifecycleOwner, Observer{ profile ->
            data.text = profile.toString()
        })

    }

    private fun addBehaviour(){
        val name = view?.findViewById<EditText>(R.id.editNametext)?.text.toString()
        if(name.length>1){
            Behaviour(0,name)
            mProfileViewModel.addBehaviour(Behaviour(0,name))
            Toast.makeText(requireContext(),"hat Funktioniert!",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(),"bitte Namen eingeben!",Toast.LENGTH_LONG).show()
        }
    }
    private fun loadBehaviour(){
        val data = requireView().findViewById<TextView>(R.id.InputNameRequestText)

        mProfileViewModel.readBehaviour
            .observe(viewLifecycleOwner, Observer{ behaviour ->
            data.text = behaviour.toString()

        })

    }


    private fun updateProfile(){
        var name = view?.findViewById<EditText>(R.id.editNametext)?.text.toString()
        mProfileViewModel.readData.observe(viewLifecycleOwner, Observer{ profile ->
            mProfileViewModel.updateProfile(Profile(1,name,profile[0].notificationZeit,profile[0].goal))
        })

    }
    private fun delete(){
        var name = view?.findViewById<EditText>(R.id.editNametext)?.text.toString()
        mProfileViewModel.readBehaviour.observe(viewLifecycleOwner, Observer{ behaviour ->
            for(i in behaviour){
                if(i.beschreibung==name) mProfileViewModel.deleteBehaviour(i)
            }

            })






    }





}