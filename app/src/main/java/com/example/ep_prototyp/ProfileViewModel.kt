package com.example.ep_prototyp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application):AndroidViewModel(application){

     val readData:LiveData<List<Profile>>
    private val repository: ProfileRepository
 //   private val readnotificationZeitData:LiveData<List<Profile>>
 //   private val readgoalData: LiveData<List<Profile>>
 //   private val readwiederholIntervallData: LiveData<List<Profile>>
   // private val readRezeptData: LiveData<List<Rezept>>
   // private val readWeekData: LiveData<List<Week>>
   // private val readListeBehaviour: LiveData<List<Behaviour>>

    init {
        val profileDao = ProfileDatabase.getDatabase(application).profileDao()
        repository = ProfileRepository(profileDao)
        readData = repository.readData
     /*   readnotificationZeitData = repository.readNotificationZeitData
        readgoalData = repository.readgoalData
        readwiederholIntervallData = repository.readwiederholIntervallData
        readRezeptData = repository.readRezeptData
        readWeekData = repository.readWeekData
        readListeBehaviour = repository.readListeBehaviour */
    }

    fun createProfile(profile: Profile){
        viewModelScope.launch(Dispatchers.IO){
            repository.createProfile(profile)
        }
    }
/*
    fun addBehaviour(beschreibung:String,einfachheit:Int,effizienz:Int){
        viewModelScope.launch(Dispatchers.IO){
            repository.addBehaviour(beschreibung,einfachheit,effizienz)
        }
    }

    fun addRezept(rezeptBehaviour:String,rezeptCelebration:Char,rezeptPrompt:Char){
        viewModelScope.launch(Dispatchers.IO){
            repository.addRezept(rezeptBehaviour,rezeptCelebration,rezeptPrompt)
        }
    }

    fun addWeek(wiederholIntervall:Int){
        viewModelScope.launch(Dispatchers.IO){
            repository.addWeek(wiederholIntervall)
        }
    }

    fun updateName(vorname: Char,nachname: Char){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateName(vorname,nachname)
        }
    }

    fun updatenotificationZeit(notificationZeit: Int){
        viewModelScope.launch(Dispatchers.IO){
            repository.updatenotificationZeit(notificationZeit)
        }
    }

    fun updategoal(goal: String){
        viewModelScope.launch(Dispatchers.IO){
            repository.updategoal(goal)
        }
    }

    fun updateBehaviour(beschreibung:String,einfachheit:Int,effizienz:Int){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateBehaviour(beschreibung,einfachheit,effizienz)
        }
    }

    fun updateRezept(rezeptBehaviour:String,rezeptCelebration:Char, rezeptPrompt:Char){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateRezept(rezeptBehaviour,rezeptCelebration, rezeptPrompt)
        }
    }

    fun updateWeek(tag:String,erledigt:Boolean){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateWeek(tag,erledigt)
        }
    }

    fun deleteBehaviour(beschreibung: String){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteBehaviour(beschreibung)
        }
    }

    fun deleteRezept(beschreibung: String){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteRezept(beschreibung)
        }
    }

    fun deleteWeek(beschreibung: String){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteWeek(beschreibung)
        }
    }

*/


}