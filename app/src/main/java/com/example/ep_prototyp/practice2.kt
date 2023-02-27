package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R


class practice2 : Fragment() {
    private lateinit var mProfileDatabase:ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_practice2, container, false)
        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)

        val button=view.findViewById<Button>(R.id.weiterZuReviewButton)

        val boxenListe=mutableListOf<CheckBox>()

        boxenListe.add(view.findViewById<CheckBox>(R.id.checkBox),)
        boxenListe.add(view.findViewById<CheckBox>(R.id.checkBox2),)
        boxenListe.add(view.findViewById<CheckBox>(R.id.checkBox3),)
        boxenListe.add(view.findViewById<CheckBox>(R.id.checkBox4),)
        boxenListe.add(view.findViewById<CheckBox>(R.id.checkBox5),)
        boxenListe.add(view.findViewById<CheckBox>(R.id.checkBox6),)
        boxenListe.add(view.findViewById<CheckBox>(R.id.checkBox7),)


        button.setOnClickListener {

            mProfileDatabase.readWeekData.observe(viewLifecycleOwner, Observer { data ->
                var counter=0
                /*
                for (i in boxenListe) {
                    if (i.isChecked) {
                        counter++
                        Toast.makeText(requireContext(),counter.toString(),Toast.LENGTH_SHORT).show()

                    }
                }
                */
                if (boxenListe[0].isChecked) {
                    counter++
                }
                if (boxenListe[1].isChecked) {
                    counter++
                }
                if (boxenListe[2].isChecked) {
                    counter++
                }
                if (boxenListe[3].isChecked) {
                    counter++
                }
                if (boxenListe[4].isChecked) {
                    counter++
                }
                if (boxenListe[5].isChecked) {
                    counter++
                }
                if (boxenListe[6].isChecked) {
                    counter++
                }

                if(data.isEmpty()){
                    mProfileDatabase.addWeek(Week(0,counter))
                }else{
                    mProfileDatabase.updateWeek(Week(1,counter))
                }

            })

            mProfileDatabase.readData.observe(viewLifecycleOwner, Observer { data->
                mProfileDatabase.updateProfile(Profile(data[0].id,data[0].name,data[0].notificationZeit,data[0].goal,0))
            })
            Thread.sleep(1000)
            findNavController().navigate(R.id.action_practice2_to_review)

        }



        return view
    }
}