package eni.demo.enidemo.listview.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import eni.demo.enidemo.R
import eni.demo.enidemo.api.Beer
import eni.demo.enidemo.databinding.FragmentListLocationBinding
import eni.demo.enidemo.room.ViewModelFactory
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class ListLocationFragment : Fragment() {

    companion object {
        fun newInstance() = ListLocationFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // binding sur le fragment
        val binding: FragmentListLocationBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_list_location, container, false)

        // Récupérer le context de l'application
        val application = requireNotNull(this.activity).application

        // Récupérer le view model
        val listLocationViewModel = ViewModelProvider(this, ViewModelFactory(application))[ListLocationViewModel::class.java]

        binding.listLocationViewModel = listLocationViewModel
        binding.lifecycleOwner = this


        // connecter l'adapter du reclycer view
        val adapter = ListLocationAdapter()
        binding.rvLocations.adapter = adapter

        // VERSION NON ASYNCHRONE
        // Version SIMPLE (Sans view model et ni DAO Room asynchrone)
        // Connecter ma liste de personne de mon listPersonViewModel à mon adapter
        /*
        var listTest =  listOf<Location>(
            Location(0, "McDo", "La maladie"))

        // Dans mon adapter
        adapter.submitList(listTest)
        // VERSION NON ASYNCHRONE
        */

        // VERSION getALl
        // OnClick
        binding.btnGetLocations.setOnClickListener { it: View? ->
            run {
                // Un tâche asynchrone
                val thread = Thread {
                    listLocationViewModel.showLocations();
                 }
                // je lance ma tâche
                thread.start()
            }
        }

        // Ecoute
        listLocationViewModel.locations.observe(viewLifecycleOwner,
            // Que faire lorsque j'ai finis de récupérer mes données en x Seconde
            Observer { it?.let {
                adapter.submitList(it)
            } })

        return binding.root
    }


}