package com.example.potioncrafting

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    private lateinit var v: View
    private val dragonviewmodel: PotionViewModel by activityViewModels()

    class MainActivity : AppCompatActivity() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView: RecyclerView = v.findViewById<RecyclerView>(R.id.recyclerview)
        var adaptador = PotionRecyclerViewAdapter(this.dragonviewmodel.potions)
        adaptador.click = { position, potion ->
            run {
                //se selecciona la poción
                this.dragonviewmodel.selected = potion
                val fm: FragmentManager = parentFragmentManager
                //caso de pantalla vertical se ha de abrir un nuevo fragmento
                if (!resources.getBoolean(R.bool.land)) {
                    fm.commit {
                        replace(R.id.fragmentContainerView, DetailFragment.newInstance())
                        addToBackStack("replacement")
                    }

                }else{
                    //se encuentra en el caso de horizontal, es necesario actualizar de alguna forma el fragmento
                    val contenedor = v.findViewById<FragmentContainerView>(R.id.detailfragmentContainerView)
                    val fragmentManager = childFragmentManager
                    var fragment= fragmentManager.findFragmentById(contenedor?.id ?: -1)
                    if(fragment!=null && fragment is DetailFragment){
                        (fragment as DetailFragment).update()
                    }
                }
            }
        }
        val layoutManager = GridLayoutManager(this.context, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adaptador
        return v
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ListFragment().apply {

            }
    }
}