package com.example.firebaselogin

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.EmailAuthCredential
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirebaseRepo {

    private val auth = Firebase.auth
    private val userCreated = MutableLiveData<FirebaseUser>()
      val passwordChange = MutableLiveData<Boolean>()
    fun getLiveData(): MutableLiveData<FirebaseUser> {
        return userCreated
    }

    fun createUser(
        email: String,
        password: String

    ) {
        Firebase.auth.signOut()
        val currentUser = auth.currentUser
        if (currentUser == null) {

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        userCreated.postValue(auth.currentUser)
                        Log.d("main", "createUser: " + (auth.currentUser?.uid ?: "null"))
                    }
                }
        } else {
            Log.d("main", "createUser: $currentUser")
        }
    }


    //    new password and mail
    fun changePassword(email: String, password: String, newPassword: String) {
        val credential = EmailAuthProvider.getCredential(email, password)
        val currentUser = auth.currentUser
        currentUser?.reauthenticate(credential)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                currentUser.updatePassword(newPassword).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        passwordChange.postValue(true)
                    } else {
                        passwordChange.postValue(false)
                    }
                }
            } else {
                passwordChange.postValue(false)
            }
        }
    }

}