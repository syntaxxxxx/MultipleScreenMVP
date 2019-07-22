package com.example.multiplescreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplescreen.R
import com.example.multiplescreen.model.Player
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_player.view.*

class MyAdapter(private val context: Context?, private val player: List<Player>?) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_player, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, index: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bindItem(player?.get(index)!!)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        if (player != null) {
            return player.size
        } else {
            return 0
        }
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(player: Player) {
            itemView.tv_player_name.text = player.name
            player.images.let {
                Picasso.get().load(it).into(itemView.iv_player)
            }
        }
    }
}