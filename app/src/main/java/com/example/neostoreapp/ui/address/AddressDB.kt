package com.example.neostoreapp.ui.address

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(AddressEntity::class)],version = 1)
abstract class AddressDB : RoomDatabase(){
    abstract fun empDao():AddressDAO


}