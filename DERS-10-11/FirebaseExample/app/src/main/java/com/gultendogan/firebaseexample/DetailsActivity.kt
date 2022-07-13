package com.gultendogan.firebaseexample

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.Timestamp.now
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.gultendogan.firebaseexample.databinding.ActivityDetailsBinding
import kotlinx.android.synthetic.main.activity_details.*
import java.sql.Timestamp
import java.util.*

class DetailsActivity : AppCompatActivity() {

    val db = Firebase.firestore
    val storage = Firebase.storage
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var auth : FirebaseAuth
    var selectedImage : Uri? = null
    var selectedBitmap : Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
    }

    fun share_button(view : View){
        if (selectedImage != null){
            val reference = storage.reference
            val uuid = UUID.randomUUID()
            var imageName = "${uuid}.jpg"

            val imageReference = reference.child("images").child(imageName)

            imageReference.putFile(selectedImage!!).addOnSuccessListener { task ->
                var uploadImageReference = reference.child("images").child(imageName)
                uploadImageReference.downloadUrl.addOnSuccessListener { uri->
                    val downloadUrl = uri.toString()
                    saveDatabase(downloadUrl)
                }
            }.addOnFailureListener{ exception ->
                Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }else{
            saveDatabase(null)
        }


    }

    private fun saveDatabase(downloadUrl : String?){

        val sharedCommend = binding.shareText.text.toString()
        val userName = auth.currentUser!!.displayName.toString()
        val date = com.google.firebase.Timestamp.now()

        val shareMap = hashMapOf<String,Any>()
        shareMap.put("sharedCommend",sharedCommend)
        shareMap.put("userName",userName)
        shareMap.put("date",date)

        if (downloadUrl != null){
            shareMap.put("imageUrl",downloadUrl)
        }

        db.collection("Shares").add(shareMap).addOnCompleteListener { task ->
            if(task.isSuccessful){
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(this,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }

    fun addImage(view : View){
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)
        }else{
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent,2)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if(requestCode == 1){
            if(grantResults.size>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galleryIntent,2)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==2 && resultCode== RESULT_OK && data != null){
            selectedImage = data.data

            if(selectedImage != null){
                if(Build.VERSION.SDK_INT >= 28){
                    val source = ImageDecoder.createSource(this.contentResolver,selectedImage!!)
                    selectedBitmap = ImageDecoder.decodeBitmap(source)
                    imageView.setImageBitmap(selectedBitmap)
                }else{
                    selectedBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver,selectedImage)
                    imageView.setImageBitmap(selectedBitmap)
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}