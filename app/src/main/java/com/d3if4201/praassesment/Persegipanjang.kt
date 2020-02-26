package com.d3if4201.praassesment


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.d3if4201.praassesment.databinding.FragmentPersegipanjangBinding
import kotlinx.android.synthetic.main.fragment_persegipanjang.*

/**
 * A simple [Fragment] subclass.
 */
class Persegipanjang(val root: View?) : Fragment() {
    private lateinit var binding: FragmentPersegipanjangBinding
    private var panjang: Double = 0.00
    private var lebar: Double = 0.00
    private var  luas: Double = 0.00
    private var keliling: Double = 0.00

    companion object{
        const val  KEY_LUAS = "key_luas"
        const val KEY_KELILING = "key_keliling"
    }

    @SuppressLint
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_persegipanjang,container,false)
        if (savedInstanceState != null){
            luas = savedInstanceState.getDouble(KEY_LUAS)
            keliling = savedInstanceState.getDouble(KEY_KELILING)
         }
        binding.btHitung.setOnClickListener{
            if (binding.eTPanjang.text.toString().isEmpty() || binding.eTLebar.text.toString().isEmpty()){
                Toast.makeText(this.activity,"Field Tidak Boleh Kosong",Toast.LENGTH_SHORT)
                    .show()
            } else{
                panjang = binding.eTPanjang.text.toString().toDouble()
                lebar = binding.eTLebar.text.toString().toDouble()
                luas = panjang * lebar
                keliling = 2 * (panjang + lebar)
                binding.textViewLuas.text = "Luas = $luas"
                binding.textViewKeliling.text = "Keliling = $keliling"
            }
        }

        binding.btShare.setOnClickListener {
            val luasPesegi = textViewLuas.text.toString()
            val kelilingPersegiPanjang = textViewKeliling.text.toString()
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,luasPesegi+"\n"+kelilingPersegiPanjang)
            shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Hasil Hitung persegi panjang")
            startActivity(Intent.createChooser(shareIntent,"Share text via..."))
        }
        return binding.root


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble(KEY_LUAS,luas)
        outState.putDouble(KEY_KELILING,keliling)
    }
    @SuppressLint
    private fun updateNilai(s1: Double, s2: Double){
        binding.textViewLuas.setText("Luas=" + s1.toString())
        binding.textViewKeliling.setText("Keliling="+s2.toString())
    }

}
