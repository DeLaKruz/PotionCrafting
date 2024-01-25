package com.example.potioncrafting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    private lateinit var v: View
    private val potionviewmodel: PotionViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    public fun update(){
        this.potionviewmodel.selected?.let {
            v.findViewById<TextView>(R.id.nombre).setText(it.nombre)
            v.findViewById<TextView>(R.id.ingredientes).setText(it.ingredientes)
            v.findViewById<TextView>(R.id.efectos).setText(it.efecto)
            v.findViewById<TextView>(R.id.tiempo).setText(it.tiempoelaboracion.toString())
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_detail, container, false)
        this.update()

        // Inflate the layout for this fragment
        return v //inflater.inflate(R.layout.fragment_detail, container, false)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            DetailFragment().apply {

            }
    }
}