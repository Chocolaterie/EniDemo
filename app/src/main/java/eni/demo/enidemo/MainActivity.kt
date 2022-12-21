package eni.demo.enidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eni.demo.enidemo.listview.ListPersonFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListPersonFragment.newInstance())
                .commitNow()
        }
    }
}