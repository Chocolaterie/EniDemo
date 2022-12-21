package eni.demo.enidemo.listview

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person (
    @PrimaryKey(autoGenerate = true) var id : Long = 0,
    var firstname : String,
    var lastname : String
) {

}