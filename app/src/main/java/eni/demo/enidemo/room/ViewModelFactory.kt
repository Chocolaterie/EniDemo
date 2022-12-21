package eni.demo.enidemo.room

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import eni.demo.enidemo.listview.ListPersonViewModel
import eni.demo.enidemo.listview.location.ListLocationViewModel

class ViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListPersonViewModel::class.java)) {
            var personneDao =
                AppDatabase.getInstance(application).personDao()
            return ListPersonViewModel(
                personneDao,
                application
            ) as T
        }
        //
        if (modelClass.isAssignableFrom(ListLocationViewModel::class.java)) {
            var locationDao =
                AppDatabase.getInstance(application).locationDao()
            return ListLocationViewModel(
                locationDao,
                application
            ) as T
        }
        throw IllegalArgumentException("ViewModel inconnu")
    }
}
