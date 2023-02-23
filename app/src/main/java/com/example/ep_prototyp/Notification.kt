package com.example.ep_prototyp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import android.widget.NumberPicker
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.work.*
import java.util.concurrent.TimeUnit


class Notification : Fragment() {

    //Notification Stuff
    private val CHANNEL_ID = "channel_id"
    private val NOTIFICATION_ID = 1
    var notiMinutes:Long = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        //NumberPicker und die Benennung
        val numberPicker = view.findViewById<NumberPicker>(R.id.numberPickerNotification)
        val numbers = resources.getStringArray(R.array.notifications)



        //NumberPicker
        numberPicker.minValue = 1
        numberPicker.maxValue = 4
        //numberPicker.value = 3
        numberPicker.displayedValues = numbers






        val button = view.findViewById<Button>(R.id.zurueckZuPracticeButton)

        button.setOnClickListener {
            notiMinutes = numberPicker.value.toLong() * 15
            myWorkManager()
            findNavController().navigate(R.id.action_fragment_notification_to_practice1)
            Toast.makeText(requireContext(), "Du wirst alle $notiMinutes Minuten benachrichtigt", Toast.LENGTH_SHORT).show()

        }


        return view
    }

    private fun myWorkManager() {
        val constraints = Constraints.Builder()
            .setRequiresCharging(false)
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .setRequiresBatteryNotLow(true)
            .build()

        val notificationWork = PeriodicWorkRequestBuilder<MyWorker>(notiMinutes, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(this.requireContext()).enqueue(notificationWork)
    }


}