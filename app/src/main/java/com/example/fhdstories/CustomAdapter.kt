package com.example.fhdstories

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


class CustomAdapter (val storiesList:ArrayList<Story>,val context: Context):
    RecyclerView.Adapter<CustomAdapter.DataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val dataHolder = DataHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_layout
        ,parent,false))
        return dataHolder

    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val story = storiesList[position]
        holder.storyTitle.text = story.title
        holder.subTitle.text = story.subtitle
        holder.storyLetter.text = story.title.first().toString()
       generateColor(holder,position)
        holder.itemView.setOnClickListener {
            val i = Intent(context,StoryDetailsActivity2::class.java)
            i.putExtra("title",story.title)
            i.putExtra("desc",story.description)
            context.startActivity(i)
        }

    }

    private fun generateColor(holder:DataHolder,position: Int){
        val r = java.util.Random()
        val red = r.nextInt(255+position)
        val green  = r.nextInt(255-position+1)
        val blue = r.nextInt(255+position+1)
        holder.cardView.setCardBackgroundColor(Color.rgb(red,green,blue))


    }

    override fun getItemCount(): Int {
        return storiesList.size
    }

    class DataHolder(item: View):RecyclerView.ViewHolder(item){
        val storyTitle:TextView= item.findViewById(R.id.title)
        val subTitle:TextView= item.findViewById(R.id.subTitle)
        val storyLetter:TextView= item.findViewById(R.id.letter)
        val cardView:CardView = item.findViewById(R.id.cardView)
    }
}