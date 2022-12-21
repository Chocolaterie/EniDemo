package eni.demo.enidemo.listview.location

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Location (
    @PrimaryKey(autoGenerate = true) var id : Long = 0,
    var name : String,
    var description : String
) {

}