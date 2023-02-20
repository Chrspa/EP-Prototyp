package com.example.ep_prototyp


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProfileDao {

    //Erstellen von Datensätzen
    @Insert
    suspend fun createProfile(profile: Profile)
/*
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBehaviour(beschreibung:String,einfachheit:Int,effizienz:Int)

    @Insert
    suspend fun addRezept(rezeptBehaviour:String,rezeptCelebration:Char,rezeptPrompt:Char)

    @Insert
    suspend fun addWeek(wiederholIntervall:Int)



    //ändern und Hinzufügen von Parametern
    @Update
    suspend fun updateName(vorname: Char,nachname: Char)

    @Update
    suspend fun updatenotificationZeit(notificationZeit: Int)

    @Update
    suspend fun updategoal(goal: String)

    @Update
    suspend fun updateBehaviour(beschreibung:String,einfachheit:Int,effizienz:Int)

    @Update
    suspend fun updateRezept(rezeptBehaviour:String,rezeptCelebration:Char, rezeptPrompt:Char)

    @Update
    suspend fun updateWeek(tag:String,erledigt:Boolean)



    //Löschen einzelner Datensätze aus den Tables
    @Delete
    suspend fun deleteBehaviour(beschreibung: String)

    @Delete
    suspend fun deleteRezept(beschreibung: String)

    @Delete
    suspend fun deleteWeek(beschreibung: String)


*/
    //Query abfragen der Datensätze
    @Query("SELECT * FROM profile_table ORDER BY id ASC")
    fun readData(): LiveData<List<Profile>>

 /*   @Query("SELECT notificationZeit FROM profile_table ORDER BY id ASC")
    fun readnotificationZeitData(): LiveData<List<Profile>>

    @Query("SELECT goal FROM profile_table ORDER BY id ASC")
    fun readgoalData(): LiveData<List<Profile>>

    @Query("SELECT wiederholIntervall FROM profile_table ORDER BY id ASC")
    fun readwiederholIntervallData(): LiveData<List<Profile>>

    @Query("SELECT * FROM rezept_table ORDER BY id ASC")
    fun readRezeptData(): LiveData<List<Rezept>>

    @Query("SELECT * FROM week_table ORDER BY id ASC")
    fun readWeekData(): LiveData<List<Week>>

    @Query("SELECT * FROM behaviour_table ORDER BY id ASC")
    fun readListeBehaviour(): LiveData<List<Behaviour>>
*/
}