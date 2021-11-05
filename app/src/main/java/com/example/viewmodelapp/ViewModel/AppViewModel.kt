package com.example.viewmodelapp.ViewModel

import android.service.autofill.UserData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodelapp.Model.User
import com.example.viewmodelapp.userdata.UserData.getUsers

class AppViewModel : ViewModel() {

    var userList:MutableLiveData<List<User>> = MutableLiveData()

    init {
        userList.value = com.example.viewmodelapp.userdata.UserData.getUsers()
    }

    fun getListUsers() = userList

    fun updateListUsers(){
        userList.value = com.example.viewmodelapp.userdata.UserData.getAnotherUsers()
    }

    fun hideUsers(){
        userList.value = userList.value?.subList(1,5)
    }

}