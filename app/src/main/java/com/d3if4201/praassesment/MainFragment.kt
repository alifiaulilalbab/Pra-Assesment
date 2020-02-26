package com.d3if4201.praassesment


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import com.d3if4201.praassesment.databinding.FragmentMainBinding



/**
 * A simple [Fragment] subclass.
 */
class MainFragment(val root: View?) : Fragment() {
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        binding.main = this
        binding.btnPersegiPanjang.setOnClickListener{
            view?.findNavController()
                ?.navigate(R.id.action_mainFragment_to_persegipanjang)
        }
        binding.btnSegitiga.setOnClickListener{
            view?.findNavController()
                ?.navigate(R.id.action_mainFragment_to_segitiga)
        }
        setHasOptionsMenu(true)
        return binding.root

        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        item!!
        view!!.findNavController()
        super.onOptionsItemSelected(item)
    }
}


