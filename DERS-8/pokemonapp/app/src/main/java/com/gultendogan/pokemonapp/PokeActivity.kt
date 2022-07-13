package com.gultendogan.pokemonapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.gultendogan.pokemonapp.databinding.ActivityPokeBinding
import java.io.ByteArrayOutputStream
import java.lang.Exception

class PokeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokeBinding

    private lateinit var activityResultLauncher : ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    var selectedBitmap : Bitmap? = null
    private lateinit var database:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerLauncher()

        val intent = intent
        val info = intent.getStringExtra("info")
        if (info.equals("new")){
            binding.nameText.setText("")
            binding.propertiesText.setText("")
            binding.numberText.setText("")
            binding.button.visibility = View.VISIBLE
        }else{
            binding.button.visibility = View.INVISIBLE
            val selectedId = intent.getIntExtra("id",1)
            database = this.openOrCreateDatabase("Pokemon", MODE_PRIVATE,null)
            val cursor = database.rawQuery("SELECT * FROM pokemon WHERE id = ?", arrayOf(selectedId.toString()))
            val pokeNameIx = cursor.getColumnIndex("pokename")
            val pokePropertiesIx = cursor.getColumnIndex("pokeproperties")
            val numberIx = cursor.getColumnIndex("pokenumber")
            val imageIx = cursor.getColumnIndex("image")

            while (cursor.moveToNext()){
                binding.nameText.setText(cursor.getString(pokeNameIx))
                binding.propertiesText.setText(cursor.getString(pokePropertiesIx))
                binding.numberText.setText(cursor.getString(numberIx))
                binding.numberText

                val byteArray = cursor.getBlob(imageIx)
                val bitmap = BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)
                binding.imageView.setImageBitmap(bitmap)
            }

            cursor.close()
        }

        binding.button.setOnClickListener {

            val pokeName = binding.nameText.text.toString()
            val pokeProperties = binding.propertiesText.text.toString()
            val pokeNumber = binding.numberText.text.toString()

            if (selectedBitmap != null){
                val smallBitmap = makeSmallerBitmap(selectedBitmap!!,300)

                val outputStream = ByteArrayOutputStream()
                smallBitmap.compress(Bitmap.CompressFormat.PNG,50,outputStream)
                val byteArray = outputStream.toByteArray()

                try {

                    val database = this.openOrCreateDatabase("Pokemon", MODE_PRIVATE,null)
                    database.execSQL("CREATE TABLE IF NOT EXISTS pokemon(id INTEGER PRIMARY KEY, pokename VARCHAR, pokeproperties VARCHAR, pokenumber VARCHAR, image BLOB)")

                    val sqlString = "INSERT INTO pokemon (pokename, pokeproperties, pokenumber, image) VALUES (?,?,?,?)"
                    val statement = database.compileStatement(sqlString)
                    statement.bindString(1,pokeName)
                    statement.bindString(2,pokeProperties)
                    statement.bindString(3,pokeNumber)
                    statement.bindBlob(4,byteArray)
                    statement.execute()

                }catch (e:Exception){
                    e.printStackTrace()
                }

                val intent = Intent(this@PokeActivity,MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }

        binding.imageView.setOnClickListener {

            if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                    Snackbar.make(binding.root,
                        "Permission needed for gallery",
                        Snackbar.LENGTH_INDEFINITE).setAction("Give Permission",
                        View.OnClickListener {
                            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                        }).show()
                }else{
                    permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                }
            }else{
                val intentToGallery = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)
            }
        }
    }

    private fun makeSmallerBitmap(image:Bitmap, maximumSize:Int) : Bitmap{
        var width = image.width
        var height = image.height

        val bitmapRatio : Double = width.toDouble() / height.toDouble()

        if(bitmapRatio > 1){
            //yatay görsel
            width = maximumSize
            val scaleHeight = width / bitmapRatio
            height = scaleHeight.toInt()
        }else{
            //dikey görsel
            height = maximumSize
            val scaleWidth = height * bitmapRatio
            width = scaleWidth.toInt()
        }

        return Bitmap.createScaledBitmap(image,width,height,true)
    }

    private fun registerLauncher(){
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK){
                val intentFromResult = result.data
                if(intentFromResult != null){
                    val imageData = intentFromResult.data
                    if(imageData != null){
                        try {
                            if(Build.VERSION.SDK_INT >= 28){
                                val source = ImageDecoder.createSource(this@PokeActivity.contentResolver,imageData)
                                selectedBitmap = ImageDecoder.decodeBitmap(source)
                                binding.imageView.setImageBitmap(selectedBitmap)
                            }else{
                                selectedBitmap = MediaStore.Images.Media.getBitmap(contentResolver,imageData)
                                binding.imageView.setImageBitmap(selectedBitmap)
                            }
                        }catch (e: Exception){
                            e.printStackTrace()
                        }
                    }

                }
            }
        }

        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ result ->
            if(result){
                val intentToGallery = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)
            }else{
                Toast.makeText(this@PokeActivity,"Permission needed!", Toast.LENGTH_LONG).show()
            }
        }
    }

}