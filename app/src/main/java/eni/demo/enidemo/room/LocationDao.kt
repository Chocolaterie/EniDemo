package eni.demo.enidemo.room

import androidx.lifecycle.LiveData
import androidx.room.*
import eni.demo.enidemo.listview.Person
import eni.demo.enidemo.listview.location.Location

@Dao
interface LocationDao {
    // CRUD : Create Read Update Delete

    @Insert
    fun insert(location: Location)

    @Query("SELECT * FROM Location")
    fun getAll() : LiveData<List<Location>>

}