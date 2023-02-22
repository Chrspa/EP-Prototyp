package com.example.ep_prototyp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    var notificationZeit: Int?,
    val goal: String?
)
/*
@Entity(tableName = "behaviour_table")
data class Behaviour(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val beschreibung:String,
    val einfachheit:Int,
    val effizienz:Int

)

@Entity(tableName = "rezept_table")
data class Rezept(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val rezeptBehaviour:String,
    val längeBehaviour:String
    val rezeptCelebration:Char,
    val rezeptPrompt:Char
)

@Entity(tableName = "week_table")
data class Week(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val erledigt :Int,
    val wiederholIntervall: Int,
    val montag:Boolean,
    val dienstag:Boolean,
    val mittwoch:Boolean,
    val donnerstag:Boolean,
    val freitag:Boolean,
    val samstag:Boolean,
    val sonntag:Boolean
)*/