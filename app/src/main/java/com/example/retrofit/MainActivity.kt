package com.example.retrofit


import android.R
import android.content.Intent
import android.os.Bundle
import android.view.WindowInsetsAnimation
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.model.Data
import com.example.retrofit.model.Users
import com.example.retrofit.network.ApiClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//retrofit menjadi jembatan dari server untuk dpt data yang dibutuhkan. butuh data daftar employee dari DB , maka butuh akses internet buat ambil data itu. Si hp bakal ngirim request yang nantinya server (DB) kash respon. si hp ini ngirim dan ngambil data dengan lib retrofit
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllUsers()
        val userList = ArrayList<Data>()

        response.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                for (i in response.body()!!.data) {
                    var data = Data(id = i.id, email = i.email, firstname = i.firstname, lastname = i.lastname, avatar = i.avatar)
                    userList.add(data)
                }
                val adapterRetrofit = RetrofitAdapter(userList){ pesan ->
                    val namadpn = pesan.firstname
                    val namablkng = pesan.lastname
                    val email = pesan.email
                    val gambar = pesan.avatar

                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    intent.putExtra("namadpn", namadpn)
                    intent.putExtra("namablkng", namablkng)
                    intent.putExtra("email", email)
                    intent.putExtra("gambar", gambar)
                    startActivity(intent)
                }
                with(binding) {
                    rvPesan.apply {
                        adapter = adapterRetrofit
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }

//                val listAdapter = ArrayAdapter(
//                    this@MainActivity,
//                    android.R.layout.simple_list_item_1,
//                    userList
//                )
//                binding.lvNama.adapter = listAdapter
            }
            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error",
                    Toast.LENGTH_LONG).show()
            }
        })
    }

}