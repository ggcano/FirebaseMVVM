package com.example.recyclerviewplatzi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewplatzi.MainAdapter
import com.example.recyclerviewplatzi.viewmodel.MainViewModel
import com.example.recyclerviewplatzi.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: MainAdapter
    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = MainAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter
        observeData()

       /* var defaultList = mutableListOf<UserModel>()
        defaultList.add(UserModel("http://pm1.narvii.com/7131/132eb1c28a0d473ae03c0fcb43e7b46aa18fef19r1-240-240v2_uhq.jpg","Default Name", "It's a default Skin"))
        defaultList.add(UserModel("http://pm1.narvii.com/6973/d45ddffd2e181cfd4f6a74f4c8ce01d10b0b1f75r1-512-288v2_00.jpg","The Dark Knight", "It's a default Skin"))
        defaultList.add(UserModel("https://esports.as.com/2019/03/26/fortnite/Consigue-gratis-nueva-skin-Fortnite_1230486944_142191_1440x600.jpg","Carbono", "It's a default Sadadadkin"))

*/
       // mAdapter.setLisData(defaultList)
      //  mAdapter.notifyDataSetChanged()
    }

    fun observeData () {
        viewModel.userData().observe(this, Observer {
            mAdapter.setLisData(it)
            mAdapter.notifyDataSetChanged()
        })
    }
}
