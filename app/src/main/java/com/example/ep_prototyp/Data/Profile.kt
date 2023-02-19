package com.example.ep_prototyp.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val vorname: Char,
    val nachname: Char,
    var notificationZeit: Int,
    val goal: String,
    val listeBehaviour: List<Behaviour>,
    val goldenBehaviour: List<Behaviour>,
    val wiederholIntervall: Int,
    val rezept:Rezept,
    val week: Week


)
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
    val rezeptBehaviour:Behaviour,
    val rezeptCelebration:Char,
    val rezeptPrompt:Char
)
@Entity(tableName = "week_table")
data class Week(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val erledigt :Int,
    val montag:Boolean,
    val dienstag:Boolean,
    val mittwoch:Boolean,
    val donnerstag:Boolean,
    val freitag:Boolean,
    val samstag:Boolean,
    val sonntag:Boolean

)