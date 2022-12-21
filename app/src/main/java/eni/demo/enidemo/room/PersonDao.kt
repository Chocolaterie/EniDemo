package eni.demo.enidemo.room

import androidx.lifecycle.LiveData
import androidx.room.*
import eni.demo.enidemo.listview.Person

@Dao
interface PersonDao {
    // CRUD : Create Read Update Delete

    @Insert
    fun insert(person: Person)

    @Query("SELECT * FROM Person WHERE id=:id")
    fun getById(id: Long) : Person

    @Query("SELECT * FROM Person")
    fun getAll() : LiveData<List<Person>>
    @Update
    fun update(person: Person)

    @Delete
    fun delete(person: Person)
}