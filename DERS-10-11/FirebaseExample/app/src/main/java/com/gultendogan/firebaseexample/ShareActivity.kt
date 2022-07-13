package com.gultendogan.firebaseexample

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_share.*

class ShareActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    val db = Firebase.firestore
    var shareList = ArrayList<Share>()
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.log_out){
            auth.signOut()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }else if(item.itemId == R.id.share){
            val intent = Intent(this,DetailsActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        auth = Firebase.auth

        getData()

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerViewAdapter = RecyclerViewAdapter(shareList)
        recyclerView.adapter = recyclerViewAdapter
    }

    fun getData(){
        db.collection("Shares").orderBy("date",Query.Direction.DESCENDING).addSnapshotListener { snapshot, error ->
            if(error != null){
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_LONG).show()
            }else{
                if(snapshot != null){
                    if (!snapshot.isEmpty){
                        val documents = snapshot.documents

                        shareList.clear()

                        for (document in documents){
                            val userNames = document.get("userName") as String
                            val sharedCommends = document.get("sharedCommend") as String
                            val imageUrls = document.get("imageUrl") as String?

                            var getShare = Share(userNames,sharedCommends,imageUrls)
                            shareList.add(getShare)
                        }

                        recyclerViewAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }


}