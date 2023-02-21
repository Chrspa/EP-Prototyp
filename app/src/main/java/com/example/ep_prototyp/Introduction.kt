package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R

class Introduction : Fragment() {

    private lateinit var introText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_introduction, container, false)

        val button=view.findViewById<Button>(R.id.nextIntroButton)
        introText = view.findViewById<TextView>(R.id.introductionTextView)

        val list = listOf<String>(
            "Mit einem smarten Verhaltens-Design und kleinen Schritten lassen sich Veränderungen nachhaltig gestalten – ganz ohne Selbstvorwürfe und Schamgefühle.",
            "Das funktioniert so:\n\n" +
                    "o\tDu fängst mit kleinen Verhaltensänderungen an, findest heraus, wie du diese in deinen Alltag integrieren und bringst sie durch stetige positive Bestärkung zur vollen Entfaltung.\n\n" +
                    "o\tDie Verhalten sind so klein und einfach, dass du dich nicht mit viel Aufwand dazu motivieren musst. Es geht darum, nach und nach neue Gewohnheiten entstehen zu lassen.\n",
            "Der feste Grundsatz lautet: „Es gibt kein Versagen!“ Du musst nicht alles gleich sofort können. \n\n Veränderungen entstehen durch positive Gefühle, nicht durch negative!",
            "Jeder kleine Schritt kann der Anfang einer neuen Gewohnheit sein. Und wenn es nicht klappt? Dann machst du ihn noch kleiner!",
            "MIND STEPS unterstützt dich dabei, Verhaltensrezepte zu finden, die für dich funktionieren. \n\n Das wissenschaftlich begründete Prinzip basiert auf dem Verhaltensmodell des promovierten Sozialwissenschaftlers B.J. Fogg von der Stanford University.",
            "Tiny is mighty! \n\n Das Gefühl von Erfolg ist der beste Motor für Veränderungen. Starte am besten noch heute!"
        )

        var index = 0
        button.setOnClickListener {
            if (index < list.size) {
                introText.text = list[index]
                index++
                introText.invalidate()
            }
            if (index == list.size) {
                button.text = "Start"
                button.setOnClickListener {
                    findNavController().navigate(R.id.action_introduction_to_analysis1)
                }
            }
        }



        return view

    }

}