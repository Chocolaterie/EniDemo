package eni.demo.enidemo.room

import android.content.Context
import android.provider.ContactsContract
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import eni.demo.enidemo.listview.Person
import eni.demo.enidemo.listview.location.Location


@Database(entities = arrayOf(Person::class, Location::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    // La dao person
    abstract fun personDao(): PersonDao
    abstract fun locationDao(): LocationDao

    companion object {
        // Singleton de la basse de données
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // La fonction pour récupèrer le singleton de la base de données
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                // get l'instance
                var instance = INSTANCE
                // Si c'est la première qu'on souhaite l'instance (donc il est null par défaut)
                if (instance == null) {
                    // Etablir notre de base de données
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "la_base_de_donnees"
                    ).build()

                    //--
                    INSTANCE = instance
                }
                // Return l'instance dans tout les cas
                return instance
            }
        }

    }
}