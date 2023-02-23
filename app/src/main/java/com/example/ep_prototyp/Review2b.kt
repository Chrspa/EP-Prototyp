package com.example.ep_prototyp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import org.w3c.dom.Text

class Review2b : Fragment() {

    private lateinit var popupWindow: PopupWindow

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_review2b, container, false)
        val popupView = inflater.inflate(R.layout.pop_up_review_nav, null)

        val allesSuperButton = view.findViewById<Button>(R.id.laeuftSuperButton)
        val vergesseHinUndWiederButton = view.findViewById<Button>(R.id.vergesseHinUndWiederButton)
        val vergesseStaendigButton = view.findViewById<Button>(R.id.vergesseStaendigButton)
        val zuSchwierigButton = view.findViewById<Button>(R.id.verhaltenZuSchwierigButton)
        val anderesMachen = view.findViewById<Button>(R.id.anderesMachenButton)

        popupWindow = PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)

        val popupHeader = popupView.findViewById<TextView>(R.id.textReviewNavHeader)
        val popupAdviceText = popupView.findViewById<TextView>(R.id.textReviewAdvice)
        val popupNavButton = popupView.findViewById<TextView>(R.id.popupNavButton)

        popupHeader.text = "So geht es für dich weiter:"

        allesSuperButton.setOnClickListener(){
            showPopUp()
            popupAdviceText.text = getString(R.string.reviewAllesGut)
            popupNavButton.text = getString(R.string.buttonTextAllesGutUndVergesseHuW)
            popupNavButton.setOnClickListener(){
                findNavController().navigate(R.id.action_review2b_to_practice1)
            }
        }

        vergesseHinUndWiederButton.setOnClickListener(){
            showPopUp()
            popupAdviceText.text = getString(R.string.reviewVergesseHinundWieder)
            popupNavButton.text = getString(R.string.buttonTextAllesGutUndVergesseHuW)
            popupNavButton.setOnClickListener(){
                findNavController().navigate(R.id.action_review2b_to_practice1)
            }
        }

        vergesseStaendigButton.setOnClickListener(){
            showPopUp()
            popupAdviceText.text = getString(R.string.reviewVergesseStaendig)
            popupNavButton.text = getString(R.string.buttonTextVergesseImmer)
            popupNavButton.setOnClickListener(){
                findNavController().navigate(R.id.action_review2b_to_design)
            }
        }

        zuSchwierigButton.setOnClickListener(){
            showPopUp()
            popupAdviceText.text = getString(R.string.reviewZuSchwer)
            popupNavButton.text = getString(R.string.buttonTextZuSchwer)
            popupNavButton.setOnClickListener(){
                findNavController().navigate(R.id.action_review2b_to_design)
            }
        }

        anderesMachen.setOnClickListener(){
            showPopUp()
            popupAdviceText.text = getString(R.string.reviewAnderesMachen)
            popupNavButton.text = getString(R.string.buttonTextAnderes)
            popupNavButton.setOnClickListener(){
                findNavController().navigate(R.id.action_review2b_to_analysis1)
            }
        }

        return view
    }

    private fun showPopUp (){
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
    }


}