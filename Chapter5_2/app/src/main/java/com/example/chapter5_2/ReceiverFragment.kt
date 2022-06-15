package com.example.chapter5_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.example.chapter5_2.databinding.FragmentReceiverBinding

class ReceiverFragment : Fragment() {
    lateinit var binding:FragmentReceiverBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceiverBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("request"){requestKey, bundle ->
            bundle.getString("valueKey")?.let{
                binding.textView.setText(it)
            }
        }
    }
}