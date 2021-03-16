package uz.example.staggeredlayoutmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import uz.example.staggeredlayoutmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = arrayListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        val adapterRv = Adapter()
        val manager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        manager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        binding.rv.layoutManager = manager
        binding.rv.adapter = adapterRv
        adapterRv.submit(list)
    }

    private fun loadData() {
        list.addAll(
            listOf(
                Data(R.drawable.horizontal1, Type.HORIZONTAL, "Grains"),
                Data(R.drawable.rice, Type.SQUARE, "Rice"),
                Data(R.drawable.melon, Type.VERTICAL, "Melon Crops"),
                Data(R.drawable.barley, Type.SQUARE, "Barley"),
                Data(R.drawable.peach_h, Type.HORIZONTAL, "Peach"),
            )
        )
    }


}