package eni.demo.enidemo.listview

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import eni.demo.enidemo.room.PersonDao

class ListPersonViewModel(val personDao: PersonDao, application: Application) : AndroidViewModel(application) {

    // On récupère la liste de toute les personnes par défaut
    var persons = personDao.getAll()

    fun initPersons(){
        personDao.insert(Person(0, "Isaac", "Schartier"))
        persons = personDao.getAll()
    }

    fun deletePersons(){
        personDao.deleteAll()
        persons = personDao.getAll()
    }
}