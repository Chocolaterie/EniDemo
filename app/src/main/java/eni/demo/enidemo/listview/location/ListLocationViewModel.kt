package eni.demo.enidemo.listview.location

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import eni.demo.enidemo.listview.Person
import eni.demo.enidemo.room.LocationDao
import eni.demo.enidemo.room.PersonDao

class ListLocationViewModel(val locationDao: LocationDao, application: Application) : AndroidViewModel(application) {

    // On récupère la liste de toute les personnes par défaut
    var locations = locationDao.getAll()


    fun showLocations(){
        locationDao.insert(Location(0, "Test", "test"))
        locations = locationDao.getAll()
        println("Test")
    }
}