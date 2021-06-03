package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.databinding.FragmentRecyclerBinding
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager

class RecyclerFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerBinding
    private lateinit var adapter: NewsRecyclerViewAdapter
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel.init()
        initRecycler()
        observes()

        binding.refresh.setOnRefreshListener {
            viewModel.init()
        }
    }

    private fun initRecycler() {
        adapter = NewsRecyclerViewAdapter()
        binding.recycler.layoutManager = LinearLayoutManager(activity)
        binding.recycler.adapter = adapter
    }

    private fun observes() {
        viewModel._newsLiveData.observe(viewLifecycleOwner, {
            when(it.status){
                Response.Status.SUCCESS -> {
                    adapter.setData(it.data!!.toMutableList())
                }
                Response.Status.ERROR -> {
                    Toast.makeText(requireActivity(),
                        it.code.toString(),
                        Toast.LENGTH_SHORT).show()
                }
                Response.Status.LOADING -> {
                    binding.refresh.isRefreshing = !binding.refresh.isRefreshing
                }
            }

        })
    }
}