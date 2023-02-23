package com.example.ep_prototyp


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProfileDao {


    //Erstellen von Datensätzen
    @Insert
    suspend fun createProfile(profile: Profile)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBehaviour(behaviour: Behaviour)



    @Insert
    suspend fun addRezept(rezept: Rezept)


    @Insert
    suspend fun addWeek(week: Week)






    //ändern und Hinzufügen von Parametern
    @Update
    suspend fun updateProfile(profile: Profile)

    @Update
    suspend fun updateBehaviour(behaviour: Behaviour)

    @Update
    suspend fun updateRezept(rezept: Rezept)

    @Update
    suspend fun updateWeek(week: Week)



    //Löschen einzelner Datensätze aus den Tables
    @Delete
    suspend fun deleteBehaviour(behaviour: Behaviour)

    @Delete
    suspend fun deleteRezept(rezept: Rezept)

    @Delete
    suspend fun deleteWeek(week: Week)



    //Query abfragen der Datensätze
    @Query("SELECT * FROM profile_table ORDER BY name ASC")
    fun readData(): LiveData<List<Profile>>


    @Query("SELECT * FROM rezept_table ORDER BY rezeptBehaviour ASC")
    fun readRezeptData(): LiveData<List<Rezept>>

    @Query("SELECT * FROM week_table ORDER BY id ASC")
    fun readWeekData(): LiveData<List<Week>>

    @Query("SELECT * FROM behaviour_table ORDER BY beschreibung ASC")
    fun readListeBehaviour(): LiveData<List<Behaviour>>


}