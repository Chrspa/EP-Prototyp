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
    val readRezeptData: LiveData<List<Rezept>>
    val readWeekData: LiveData<List<Week>>
    val readBehaviour: LiveData<List<Behaviour>>

    init {
        val profileDao = ProfileDatabase.getDatabase(application).profileDao()
        repository = ProfileRepository(profileDao)
        readData = repository.readData
       // readnotificationZeitData = repository.readNotificationZeitData
       // readgoalData = repository.readgoalData
       // readwiederholIntervallData = repository.readwiederholIntervallData
        readRezeptData = repository.readRezeptData
        readWeekData = repository.readWeekData
        readBehaviour = repository.readListeBehaviour
    }

    fun createProfile(profile: Profile){
        viewModelScope.launch(Dispatchers.IO){
            repository.createProfile(profile)
        }
    }

    fun addBehaviour(behaviour: Behaviour){
        viewModelScope.launch(Dispatchers.IO){
            repository.addBehaviour(behaviour)
        }
    }

    fun addRezept(rezept: Rezept){
        viewModelScope.launch(Dispatchers.IO){
            repository.addRezept(rezept)
        }
    }

    fun addWeek(week: Week){
        viewModelScope.launch(Dispatchers.IO){
            repository.addWeek(week)
        }
    }
    fun updateProfile(profile: Profile){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateProfil(profile)
        }
    }

    fun updateBehaviour(behaviour: Behaviour){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateBehaviour(behaviour)
        }
    }

    fun updateRezept(rezept: Rezept){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateRezept(rezept)
        }
    }

    fun updateWeek(week: Week){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateWeek(week)
        }
    }

    fun deleteBehaviour(behaviour: Behaviour){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteBehaviour(behaviour)
        }
    }

    fun deleteRezept(rezept: Rezept){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteRezept(rezept)
        }
    }

    fun deleteWeek(week: Week){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteWeek(week)
        }
    }




}