package com.example.randomusertest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.randomusertest.R
import com.example.randomusertest.models.User
import com.squareup.picasso.Picasso
import javax.inject.Inject

class UserAdapter(private val picasso: Picasso) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val users: MutableList<User> = ArrayList()

    fun setUsers(users: List<User>) {
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder) {
            holder.bind(users[position])
        }
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = itemView.findViewById(R.id.user_image)
        private val name: TextView = itemView.findViewById(R.id.user_name)

        fun bind(user: User) {
            picasso.load(user.picture?.medium).into(image)
            name.text = user.name.first + " " + user.name.last
        }
    }
}