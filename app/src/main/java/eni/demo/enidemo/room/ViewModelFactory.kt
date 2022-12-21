package eni.demo.enidemo.room

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import eni.demo.enidemo.listview.ListPersonViewModel

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
        throw IllegalArgumentException("ViewModel inconnu")
    }
}
