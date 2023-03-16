package com.example.forismatic

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forismatic.databinding.FragmentQouteListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QouteListFragment : Fragment() {
    private lateinit var binding: FragmentQouteListBinding
    val viewModel:QouteViewModel by viewModels()
    val adapter:QouteAdapter= QouteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQouteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    initAdapter()




        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.listData?.observe(viewLifecycleOwner){



                    adapter.qouteList=it






            }


        }



       /* viewModel.listData?.observe(viewLifecycleOwner){

            adapter.qouteList=it


        }
*/


    }

    private fun initAdapter() {

        binding.rv.adapter=adapter
        binding.rv.layoutManager=LinearLayoutManager(this.requireActivity(),LinearLayoutManager.VERTICAL,false)
    }


}