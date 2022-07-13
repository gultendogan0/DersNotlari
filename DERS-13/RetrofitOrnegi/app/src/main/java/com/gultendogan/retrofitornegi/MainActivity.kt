package com.gultendogan.retrofitornegi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gultendogan.retrofitornegi.adapter.RecyclerViewAdapter
import com.gultendogan.retrofitornegi.databinding.ActivityMainBinding
import com.gultendogan.retrofitornegi.model.PokemonModel
import com.gultendogan.retrofitornegi.service.PokemonAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var pokemonModels: ArrayList<PokemonModel>? = null
    private var recyclerViewAdapter : RecyclerViewAdapter? = null

    //Disposable
    private var compositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        compositeDisposable = CompositeDisposable()

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        loadData()
    }

    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(PokemonAPI::class.java)


        compositeDisposable?.add(retrofit.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))
    }

    private fun handleResponse(cryptoList : List<PokemonModel>){
        pokemonModels = ArrayList(cryptoList)

        pokemonModels?.let {
            recyclerViewAdapter = RecyclerViewAdapter(it,this@MainActivity)
            binding.recyclerView.adapter = recyclerViewAdapter
        }
    }

    fun onItemClick(pokemonModel: PokemonModel) {
        Toast.makeText(this,"Clicked : ${pokemonModel.name}", Toast.LENGTH_LONG ).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable?.clear()
    }
}