package com.example.viewmodelapp.ViewModel

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelapp.Model.User
import com.example.viewmodelapp.R
import com.example.viewmodelapp.userdata.UserData
import kotlinx.android.synthetic.main.useritem.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserHolder>() {


    private var users:List<User> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {

        return UserHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.useritem,parent,false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {

        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    @SuppressLint("NotifyDataSetChanged")
    fun swapUsers(users:List<User>){
     this.users = users
        notifyDataSetChanged()

    }

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(newUser: User) = with(itemView) {
            user_name_tv.text = newUser.name
            user_description_tv.text = newUser.description
        }

    }
}
