package com.example.firebaselogin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import com.example.firebaselogin.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseViewModel: FirebaseViewModel
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = Firebase.auth


        firebaseViewModel = ViewModelProvider(this)[FirebaseViewModel::class.java]

        firebaseViewModel.getLiveData().observe(this, Observer {
            if (it as FirebaseUser != null) {
                Toast.makeText(this, "we get loged in", Toast.LENGTH_LONG).show()
            }
        })


        firebaseViewModel.getPassChangeLiveData().observe(this, Observer {
            if (it as Boolean) {
                Toast.makeText(this, "password change", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "password not changed error occures", Toast.LENGTH_LONG).show()
            }
        })


        binding.button.setOnClickListener {
            Log.d("main", "onCreate: " + binding.editTextTextEmailAddress.text.toString())
            Log.d("main", "onCreate: " + binding.editTextTextPassword.text.toString())

            firebaseViewModel.createUser(
                binding.editTextTextEmailAddress.text.toString(),
                binding.editTextTextPassword.text.toString()

            )
        }


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)






        binding.changePassword.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            launcher.launch(signInIntent)
        }


    }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleResults(task)
            } else {
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
            }
        }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result
            if (account != null) {
                updateUI(account)
            }
        } else {
            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                binding.email.text = auth.currentUser?.email.toString()
            } else {
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

}