package com.example.ep_prototyp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    var notificationZeit: Int?=null,
    val goal: String?=null,
    val PracticeViewFlag: Int=0
)



@Entity(tableName = "behaviour_table")
data class Behaviour(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val beschreibung:String,
    val effizienz:Int?=null,
    val einfachheit:Int?=null
)



@Entity(tableName = "rezept_table")
data class Rezept(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val rezeptBehaviour:String,
    val längeBehaviour:String?=null,
    val rezeptCelebration:String?=null,
    val rezeptPrompt:String?=null
)

@Entity(tableName = "week_table")
data class Week(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val erledigt :Int,
    val wiederholIntervall: Int?=null,
    val montag:Boolean=false,
    val dienstag:Boolean=false,
    val mittwoch:Boolean=false,
    val donnerstag:Boolean=false,
    val freitag:Boolean=false,
    val samstag:Boolean=false,
    val sonntag:Boolean=false
)

