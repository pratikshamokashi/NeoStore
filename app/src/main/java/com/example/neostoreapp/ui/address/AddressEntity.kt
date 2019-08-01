package com.example.neostoreapp.ui.address

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity
    class AddressEntity {
        @PrimaryKey(autoGenerate = true)
        var id: Int=0
        @ColumnInfo(name = "address")
        var address :String=""
        @ColumnInfo(name = "city1")
        var city1 :String=""
        @ColumnInfo(name = "city2")
        var city2 :String=""
        @ColumnInfo(name = "state")
        var state :String=""
        @ColumnInfo(name = "zipcode")
        var zipcode :String=""
        @ColumnInfo(name = "country")
        var country :String=""

    }
