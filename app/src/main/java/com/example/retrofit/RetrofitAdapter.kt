package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ItemUserBinding
import com.example.retrofit.model.Data

typealias OnClickRetro = (Data) -> Unit
class RetrofitAdapter(private val listretrofit : ArrayList<Data>,private val onClickRetro: OnClickRetro) : RecyclerView.Adapter<RetrofitAdapter.ItemRetrofitViewHolder>() {

    inner class ItemRetrofitViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            with(binding) {
                txtNamaPengirim.text = "Name: " +data.firstname + " " + data.lastname
                txtTitle.text = "Email: " +data.email

                Glide.with(itemView.context)
                    .load(data.avatar) // pastikan `data.imageUrl` adalah URL gambar yang valid
                    .into(imageorang)

                itemView.setOnClickListener {
                    onClickRetro(data)
                }
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RetrofitAdapter.ItemRetrofitViewHolder {
        val binding =
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false)
        return ItemRetrofitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrofitAdapter.ItemRetrofitViewHolder, position: Int) {
        return holder.bind(listretrofit[position])

    }

    override fun getItemCount(): Int {
        return listretrofit.size
    }
}