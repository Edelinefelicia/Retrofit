package com.example.retrofit

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            val namadpn = intent.getStringExtra("namadpn")
            val namablkng = intent.getStringExtra("namablkng")
            val email = intent.getStringExtra("email")
            val gambar = intent.getStringExtra("gambar")
            Glide.with(this@MainActivity2)
                .load(gambar) // pastikan `data.imageUrl` adalah URL gambar yang valid
                .into(imageorang)

            binding.txtEmail.text = "Email: " + email
            binding.txtNama.text = "Name : " + namadpn +" " +namablkng


        }
    }
}