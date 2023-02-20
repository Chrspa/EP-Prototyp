package com.example.ep_prototyp

import androidx.lifecycle.LiveData

class ProfileRepository(private val profileDao: ProfileDao){

    //read
    val readData: LiveData<List<Profile>> = profileDao.readData()

  /*  val readNotificationZeitData: LiveData<List<Profile>> = profileDao.readnotificationZeitData()

    val readgoalData: LiveData<List<Profile>> = profileDao.readgoalData()

    val readwiederholIntervallData: LiveData<List<Profile>> = profileDao.readwiederholIntervallData()

    val readRezeptData: LiveData<List<Rezept>> = profileDao.readRezeptData()

    val readWeekData: LiveData<List<Week>> = profileDao.readWeekData()

    val readListeBehaviour: LiveData<List<Behaviour>> = profileDao.readListeBehaviour()

*/
    /*
    //insert
    suspend fun addBehaviour(beschreibung:String,einfachheit:Int,effizienz:Int){
        profileDao.addBehaviour(beschreibung,einfachheit,effizienz)
    }
*/
    suspend fun createProfile(profile: Profile){

        profileDao.createProfile(profile)
    }
/*
    suspend fun addRezept(rezeptBehaviour:String,rezeptCelebration:Char,rezeptPrompt:Char){
        profileDao.addRezept(rezeptBehaviour,rezeptCelebration,rezeptPrompt)
    }

    suspend fun addWeek(wiederholIntervall:Int){
        profileDao.addWeek(wiederholIntervall)
    }

    //update

    suspend fun updateName(vorname: Char,nachname: Char){
        profileDao.updateName(vorname,nachname)
    }
    suspend fun updatenotificationZeit(notificationZeit: Int){
        profileDao.updatenotificationZeit(notificationZeit)
    }
    suspend fun updategoal(goal: String){
        profileDao.updategoal(goal)
    }
    suspend fun updateBehaviour(beschreibung:String,einfachheit:Int,effizienz:Int){
        profileDao.updateBehaviour(beschreibung,einfachheit,effizienz)
    }
    suspend fun updateRezept(rezeptBehaviour:String,rezeptCelebration:Char, rezeptPrompt:Char){
        profileDao.updateRezept(rezeptBehaviour,rezeptCelebration,rezeptPrompt)
    }
    suspend fun updateWeek(tag:String,erledigt:Boolean){
        profileDao.updateWeek(tag,erledigt)
    }

    //Löschen

    suspend fun deleteBehaviour(beschreibung: String){
        profileDao.deleteBehaviour(beschreibung)
    }

    suspend fun deleteRezept(beschreibung: String){
        profileDao.deleteRezept(beschreibung)
    }

    suspend fun deleteWeek(beschreibung: String){
        profileDao.deleteWeek(beschreibung)
    }


*/


}