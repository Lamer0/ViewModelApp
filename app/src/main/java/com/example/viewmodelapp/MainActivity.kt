package com.example.viewmodelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.inflate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodelapp.ViewModel.AppViewModel
import com.example.viewmodelapp.ViewModel.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater


class MainActivity : AppCompatActivity() {

    private val appViewModel by lazy {ViewModelProvider(this).get(AppViewModel::class.java)  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = UserAdapter()

        userslist_rv.adapter = adapter

        userslist_rv.layoutManager = LinearLayoutManager(this)

        appViewModel.getListUsers().observe(this, Observer {
            it?.let {
            adapter.swapUsers(it)
        }
        })
    }

    //Союытия меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.mainmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item?.itemId){
            R.id.refresh -> {
                appViewModel.updateListUsers()
            }
            R.id.hide -> {
                appViewModel.hideUsers()
            }
        }

        return super.onOptionsItemSelected(item)
    }


}