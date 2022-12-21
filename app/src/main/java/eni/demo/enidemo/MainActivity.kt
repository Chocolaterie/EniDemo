package eni.demo.enidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eni.demo.enidemo.api.DemoApiFragment
import eni.demo.enidemo.listview.ListPersonFragment
import eni.demo.enidemo.listview.location.ListLocationFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DemoApiFragment.newInstance())
                .commitNow()
        }
    }
}