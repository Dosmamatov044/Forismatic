package com.example.forismatic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.forismatic.databinding.FragmentMainBinding
import kotlin.math.log


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    val viewModel: QouteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)










        viewModel.lastData?.observe(viewLifecycleOwner){
            binding.tvAutor.text=it?.quoteAuthor
            binding.tvQoute.text=it?.quoteText
            Log.d("mmmm",it?.quoteText.toString())

        }

        viewModel.data.observe(viewLifecycleOwner){

            binding.tvAutor.text=it.quoteAuthor
            binding.tvQoute.text=it.quoteText

        }


        binding.btnSave.setOnClickListener {




            viewModel.setToRoom(this.requireActivity().application)


        }







        binding.button.setOnClickListener {


           viewModel.getFromRetrofit()



        }


binding.btnFavorite.setOnClickListener {

    findNavController().navigate(R.id.action_mainFragment_to_qouteListFragment)



}





    }



}
