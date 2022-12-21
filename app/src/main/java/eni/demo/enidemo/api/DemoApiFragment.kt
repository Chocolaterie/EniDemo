package eni.demo.enidemo.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import eni.demo.enidemo.R
import eni.demo.enidemo.databinding.FragmentDemoApiBinding
import eni.demo.enidemo.databinding.FragmentListLocationBinding
import eni.demo.enidemo.listview.location.ListLocationFragment
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class DemoApiFragment : Fragment() {

    companion object {
        fun newInstance() = DemoApiFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // binding sur le fragment
        val binding: FragmentDemoApiBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_demo_api, container, false)

        // TESTER API
        val clientOkHttpClient = OkHttpClient()
        // Préparer le requete htttp
        val request = Request.Builder().url("https://api.punkapi.com/v2/beers").build()
        //
        clientOkHttpClient.newCall(request).enqueue(object: Callback {
            // Que faire quand ça fail
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            // Que faire quand j'ai une réponse
            override fun onResponse(call: Call, response: Response) {
                // Si la réponse est valide (200 par example)
                if (response.isSuccessful){
                    // Récupérer le json de la réponse
                    val jsonString = response.body?.string()
                    val arrayBeer = JSONArray(jsonString)


                    for (i in 0 until arrayBeer.length()){
                        // On récupère l'objet json de l'occurrence actual (i) du tableau
                        var jsonObject = arrayBeer[i] as JSONObject

                        // Mapping Données physique -> Données objet
                        var beer = Beer(jsonObject.getString("id"), jsonObject.getString("name"), jsonObject.getString("description"))

                        // Afficher la bière
                        println(String.format("Biere nom = %s", beer.name))
                    }

                }
            }
        })

        return binding.root
    }
}