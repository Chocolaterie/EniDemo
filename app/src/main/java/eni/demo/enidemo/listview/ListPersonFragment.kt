package eni.demo.enidemo.listview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import eni.demo.enidemo.R
import eni.demo.enidemo.databinding.FragmentListPersonBinding
import eni.demo.enidemo.room.ViewModelFactory
import kotlinx.coroutines.launch

class ListPersonFragment : Fragment() {

    companion object {
        fun newInstance() = ListPersonFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // binding sur le fragment
        val binding: FragmentListPersonBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_list_person, container, false)

        // Récupérer le context de l'application
        val application = requireNotNull(this.activity).application

        // Récupérer le view model
        val listPersonViewModel = ViewModelProvider(this, ViewModelFactory(application))[ListPersonViewModel::class.java]

        binding.listPersonViewModel = listPersonViewModel
        binding.lifecycleOwner = this

        binding.btnLancerDe.setOnClickListener { it: View? ->
            run {
                listPersonViewModel.initPersons()

            }
        }
        // connecter l'adapter du reclycer view
        val adapter = ListPersonAdapter()
        binding.rvPersonnes.adapter = adapter

        // Connecter ma liste de personne de mon listPersonViewModel à mon adapter

        listPersonViewModel.persons.observe(viewLifecycleOwner,
            Observer { it?.let { adapter.submitList(it) } })

        return binding.root
    }


}