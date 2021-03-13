package com.foreach.android.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.foreach.android.R
import com.foreach.entities.roommodel.ThemesEntity

class ThemesAdapter(var listener : OnThemesItemClickListener) : RecyclerView.Adapter<ThemesAdapter.ThemesViewHolder>() {

    var list : ArrayList<ThemesEntity> = arrayListOf()


    class ThemesViewHolder(item : View) : RecyclerView.ViewHolder(item){

        var image  : ImageView = item.findViewById(R.id.themeImage)
        var title  : TextView = item.findViewById(R.id.themeTitle)
        var layout : ConstraintLayout = item.findViewById(R.id.layout)

        fun setPhoto(url : String){
            Glide.with(image.context).load(url)
                .into(image)
        }


        fun setName(name : String){
            title.text = name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemesViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.themes_item,parent,false)
        return ThemesViewHolder(v)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ThemesViewHolder, position: Int) {

        holder.setPhoto(list[position].url)
        holder.setName(list[position].title)

        holder.layout.setOnClickListener {
            listener.onThemeClick(list[holder.adapterPosition])
        }

    }


    interface OnThemesItemClickListener{
        fun onThemeClick(themesEntity: ThemesEntity)
    }

    @JvmName("setList1")
    fun setList(list : ArrayList<ThemesEntity>){
        this.list = list
        notifyDataSetChanged()
    }

}