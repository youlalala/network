package org.techtown.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.network.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var userintent=getIntent()
        binding.idTxt.text = userintent.getStringExtra("id")
        binding.jokeTxt.text = userintent.getStringExtra("joke")
    }
}