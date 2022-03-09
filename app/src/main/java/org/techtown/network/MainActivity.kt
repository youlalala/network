package org.techtown.network


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.techtown.network.databinding.ActivityMainBinding
import org.techtown.network.network.ApiWrapper
import org.techtown.network.recycle.MyAdapter


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiWrapper.getJokeList { it->
            Log.i("la",it.toString())
            binding.recyclerView.adapter=MyAdapter(it, onClickItem={
                val intent = Intent(baseContext, DetailActivity::class.java)
                intent.putExtra("id",it.id)
                intent.putExtra("joke",it.joke)
                startActivity(intent)
            })
        }

    }
}

