package com.example.firebaselogin

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser

class FirebaseViewModel : ViewModel() {
    private val firebaseRepo = FirebaseRepo()


    fun getLiveData(): MutableLiveData<FirebaseUser> {
        return firebaseRepo.getLiveData()
    }

    fun getPassChangeLiveData(): MutableLiveData<Boolean> {
        return firebaseRepo.passwordChange
    }

    fun changePassword(email: String, password: String, newPass: String) {
        firebaseRepo.changePassword(email, password, newPass)
    }

    fun createUser(email: String, password: String) {
        firebaseRepo.createUser(email, password)
    }


}