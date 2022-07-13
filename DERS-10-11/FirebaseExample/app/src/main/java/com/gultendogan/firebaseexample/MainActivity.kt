package com.gultendogan.firebaseexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import com.gultendogan.firebaseexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        val currentUser = auth.currentUser

        if (currentUser != null){
            val intent = Intent(this,ShareActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun signUp (view : View){

        val email = binding.emailText.text.toString()
        val parola = binding.parolaText.text.toString()
        val userName = binding.userNameText.text.toString()

        auth.createUserWithEmailAndPassword(email,parola).addOnCompleteListener { task ->
            if (task.isSuccessful){
                val currentUser = auth.currentUser

                val profileUpdateRequest = userProfileChangeRequest {
                    displayName = userName
                }

                if(currentUser != null){
                    currentUser.updateProfile(profileUpdateRequest).addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(applicationContext,"Profil Kullanıcı Adı Eklendi",Toast.LENGTH_LONG).show()
                        }
                    }
                }

                Toast.makeText(applicationContext,"Kullanıcı Oluşturuldu!",Toast.LENGTH_LONG).show()
                val intent = Intent(this,ShareActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }

    fun signIn (view : View){
        val email = binding.emailText.text.toString()
        val parola = binding.parolaText.text.toString()

        if (parola != "" && email != ""){
            auth.signInWithEmailAndPassword(email,parola).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val currentUser = auth.currentUser?.displayName.toString()
                    Toast.makeText(applicationContext,"Hoşgeldin : ${currentUser}",Toast.LENGTH_LONG).show()

                    val intent = Intent(this,ShareActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }
    }
}