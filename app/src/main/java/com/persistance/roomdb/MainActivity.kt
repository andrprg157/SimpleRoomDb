package com.persistance.roomdb

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var btninsert : Button;
    lateinit var btnselect : Button;
    lateinit var context: Context;
    lateinit var db : User_Dao
    private  val TAG = "zzzzzz"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this;
        btninsert = findViewById(R.id.btninsert)
        btnselect = findViewById(R.id.btnselect)
        db = AppDatabase.getDatabase(context)!!.userDao()
        btnselect.setOnClickListener {
            GlobalScope.launch {
                var all =  db.getAllUsers()
                Log.d(TAG, "onCreate: select = $all")
            }
        }
        btninsert.setOnClickListener {
            GlobalScope.launch {
                db.insertUser(User_Entitiy(0,"nnnn","1111111"))
            }
        }


    }
}