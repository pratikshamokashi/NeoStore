package com.example.neostoreapp.ui.address

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AddressDAO {


        @Insert
        fun saveData(address_entity: AddressEntity)

        @Query("select * from AddressEntity")
        fun reademp():List<AddressEntity>

}