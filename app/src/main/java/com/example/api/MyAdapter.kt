package com.example.api

import Product
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MyAdapter(val context:Activity,val productList:List<Product>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current=productList[position]
        holder.title.text=current.title
        Picasso.get().load(current.thumbnail).into(holder.image);
        holder.rate.text=current.rating.toString()
    }
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val title:TextView
        val image:ShapeableImageView
        val rate:TextView

        init{
            title=itemView.findViewById(R.id.name)
            image=itemView.findViewById(R.id.pic)
            rate=itemView.findViewById(R.id.rating)


        }
    }
}