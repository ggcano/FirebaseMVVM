package com.example.recyclerviewplatzi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class MainAdapter(private val context: Context): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var dataList = mutableListOf<UserModel>()

    fun setLisData(data:MutableList<UserModel>){
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
    val view = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
      if (dataList.size >0) {
          return dataList.size
      } else {
          return 0
      }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = dataList[position]
        holder.bindView(user)
    }

    inner class  ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bindView(user: UserModel) {
            Glide.with(context)
                .load(user.imageUrl)
                .into(itemView.circleImageView)

            itemView.txt_desc.text = user.description
            itemView.txt_title.text= user.name
        }
    }

}