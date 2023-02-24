package com.geektech.myapplication

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.myapplication.databinding.FragmentFirstrFagmentBinding

class FirstrFagment : Fragment() {

    private lateinit var binding:FragmentFirstrFagmentBinding
    var click = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentFirstrFagmentBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        binding.minus.visibility = View.GONE
    }

    private fun initListener() {
        binding.plus.setOnClickListener {
            binding.zero.text = click.toString()
        click++
            if (click == 10 ) {
                binding.plus.visibility = View.GONE
                binding.minus.visibility = View.VISIBLE
            }
        }
        binding.minus.setOnClickListener {
            binding.zero.text = click.toString()
            click--
            if (click == -1) {
                val bundle = Bundle()
                bundle.putString("number", binding.zero.text.toString())

                val secondFragment = SecondFragment()
                secondFragment.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, secondFragment).addToBackStack(null ).commit()



            }
        }

    }

}