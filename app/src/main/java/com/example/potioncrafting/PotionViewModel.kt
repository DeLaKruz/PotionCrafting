package com.example.potioncrafting

import androidx.lifecycle.ViewModel

class PotionViewModel : ViewModel() {
    private var _potions: MutableList<Potion>
    private var _selected: Potion? = null
    val potions: List<Potion>
        get() = _potions.toList()
    var selected: Potion?
        get() = _selected
        set(item) {
            _selected = item
        }

    init {
        this._potions = mutableListOf()
        this._potions.add(
            Potion(
                "Sanación",
                "Cura al usuario",
                "Flor de vida, Hoja de Agua",
                12
            )
        )
        this._potions.add(
            Potion(
                "Magia",
                "Restaura el maná del usuario",
                "Enredadera celeste, Pétalo de Mártium",
                30
            )
        )
        this._potions.add(
            Potion(
                "Explosión",
                "Genera una explosión a los 5 segundos de romper su frasco",
                "Flor de estambre de pólvora, Tallo de rosa ígnea",
                45
            )
        )
        this._potions.add(
            Potion(
                "Veneno",
                "Derriba al instante a quien lo consuma, ya sea una rata o un humano.",
                "Alas de Escarabajo Carmesí, Restos de Lokio",
                180
            )
        )

    }
}