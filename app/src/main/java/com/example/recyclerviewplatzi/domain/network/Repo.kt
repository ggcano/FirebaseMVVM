package com.example.recyclerviewplatzi.domain.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recyclerviewplatzi.UserModel
import com.google.firebase.firestore.FirebaseFirestore

class Repo {

     fun getUserData (): LiveData<MutableList<UserModel>>{
         val mutableData = MutableLiveData<MutableList<UserModel>>()
    FirebaseFirestore.getInstance().collection("Usuarios").get ().addOnSuccessListener {result ->
    val lisData = mutableListOf<UserModel>()
        for (document in result) {
        val imageUrl = document.getString("imageUrl")
        val nombre = document.getString("name")
        val descripcion = document.getString("description")
            val usuario = UserModel (imageUrl!!,nombre!!,descripcion!!)
            lisData.add(usuario)
    }
        mutableData.value = lisData
    }
return mutableData
     }
}