package com.example.coroutineviewmodellivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineviewmodellivedata.model.User
import com.example.coroutineviewmodellivedata.model.UserRepository
import kotlinx.coroutines.*

class ViewModelClass : ViewModel() {
//    //Inefficient method:
//    private val myJob = Job()
//    private val myScope = CoroutineScope(Dispatchers.IO + myJob)
//    fun getUserData(){
//        myScope.launch {
//            //do smth here
//        }
//    }
//    override fun onCleared() {
//        //        //need to cancel coroutine to prevent memory leaks
////        super.onCleared()
////        myJob.cancel()// cancel coroutines manually but how to do it for 100 coroutines??
////        //use view model scope
//    }

    //everytime a view model is created, there needs to be an onclear method

    private var userRepository = UserRepository()
    var userDataList: MutableLiveData<List<User>?> = MutableLiveData()
    fun getUserData(){
        viewModelScope.launch {
            var result: List<User>? = null
            withContext(Dispatchers.IO){
                result = userRepository.getUser()
            }
            userDataList.value = result
            //do smth here
        }
    }
}