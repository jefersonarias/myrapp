package com.example.myrapp

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrapp.Pojitos.Posts
import kotlinx.android.synthetic.main.recview.view.*
import android.content.ClipData.Item
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET



@Suppress("RedundantSemicolon")
class MyAdapter (private var cryptolist : ArrayList<Posts>) : RecyclerView.Adapter<MyAdapter.ViewHolder>()   {

    interface Listener {
        fun onItemClick (cryptolist:Posts)
    }

    private val colors : Array<String> = arrayOf("#7E57C2", "#42A5F5", "#26C6DA", "#66BB6A", "#FFEE58", "#FF7043" , "#EC407A" , "#d32f2f")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recview, parent, false)
        return ViewHolder(view)

    }
        override fun getItemCount(): Int{
        return cryptolist.size
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            //do sth in here
        }
        holder.bind(cryptolist[position], colors, position)
                //the same as bottom but worst... i guess ***********************************

    }

        //remueve el item con wipe (o almenos eso intenta)**********************************
        fun removeitem(viewHolder: RecyclerView.ViewHolder) {
            cryptolist.removeAt(viewHolder.adapterPosition)
        }

    class ViewHolder (v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        override fun onClick(v: View?) {

        }

        fun bind(cryptolist: Posts, colors : Array<String>, position: Int ) {
            //Listen for user input events//
            for(i in 0..100) {
                itemView.text_id.text = cryptolist.id
                itemView.text_userId.text = cryptolist.userId
                itemView.text_body.text = cryptolist.body
                itemView.text_title.text = cryptolist.title
                itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))

            }
        }
    }

}





