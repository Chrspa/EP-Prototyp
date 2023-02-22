package com.example.ep_prototyp

import androidx.lifecycle.LiveData

class ProfileRepository(private val profileDao: ProfileDao){

    //read
    val readData: LiveData<List<Profile>> = profileDao.readData()

   // val readNotificationZeitData: LiveData<List<Profile>> = profileDao.readnotificationZeitData()

  //  val readgoalData: LiveData<List<Profile>> = profileDao.readgoalData()

  //  val readwiederholIntervallData: LiveData<List<Profile>> = profileDao.readwiederholIntervallData()


    val readRezeptData: LiveData<List<Rezept>> = profileDao.readRezeptData()

    val readWeekData: LiveData<List<Week>> = profileDao.readWeekData()

    val readListeBehaviour: LiveData<List<Behaviour>> = profileDao.readListeBehaviour()



    //insert
    suspend fun addBehaviour(behaviour: Behaviour){
        profileDao.addBehaviour(behaviour)
    }


    suspend fun createProfile(profile: Profile){

        profileDao.createProfile(profile)
    }


    suspend fun addRezept(rezept: Rezept){
        profileDao.addRezept(rezept)
    }

    suspend fun addWeek(week: Week){
        profileDao.addWeek(week)
    }


    //update

    suspend fun updateProfil(profile: Profile){
        profileDao.updateProfile(profile)

    }
    suspend fun updateBehaviour(behaviour: Behaviour){
        profileDao.updateBehaviour(behaviour)
    }
    suspend fun updateRezept(rezept: Rezept){
        profileDao.updateRezept(rezept)
    }
    suspend fun updateWeek(week: Week){
        profileDao.updateWeek(week)
    }

    //Löschen

    suspend fun deleteBehaviour(behaviour: Behaviour){
        profileDao.deleteBehaviour(behaviour)
    }

    suspend fun deleteRezept(rezept: Rezept){
        profileDao.deleteRezept(rezept)
    }

    suspend fun deleteWeek(week: Week){
        profileDao.deleteWeek(week)
    }





}