package uz.example.staggeredlayoutmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewbinding.ViewBinding
import uz.example.staggeredlayoutmanager.databinding.ItemHorizontalBinding
import uz.example.staggeredlayoutmanager.databinding.ItemSquareBinding
import uz.example.staggeredlayoutmanager.databinding.ItemVerticalBinding


class Adapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val list: ArrayList<Data> = ArrayList()
    fun submit(ls: List<Data>) {
        list.clear()
        list.addAll(ls)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val (width, height) = parent.context.getScreenResolution()
        val binding: ViewBinding
        when (viewType) {
            Type.HORIZONTAL.ordinal -> {
                binding = ItemHorizontalBinding.inflate(LayoutInflater.from(parent.context))
                return HorizontalVH(binding).also { holder ->
                    val layoutParams = StaggeredGridLayoutManager.LayoutParams(
                        width,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    layoutParams.isFullSpan = true
                    holder.itemView.layoutParams = layoutParams
                }
            }
            Type.VERTICAL.ordinal -> {
                binding = ItemVerticalBinding.inflate(LayoutInflater.from(parent.context))
                return VerticalVH(binding).also { holder ->
                    val layoutParams =
                        holder.itemView.layoutParams ?: StaggeredGridLayoutManager.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            width
                        )
                    holder.itemView.layoutParams = layoutParams
                }
            }
            Type.SQUARE.ordinal -> {
                binding = ItemSquareBinding.inflate(LayoutInflater.from(parent.context))
                return SquareVH(binding)
            }
            else -> {
                binding = ItemSquareBinding.inflate(LayoutInflater.from(parent.context))
                return SquareVH(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HorizontalVH -> {
                holder.bind(list[position])
            }
            is VerticalVH -> {
                holder.bind(list[position])
                /*val layoutParams = holder.itemView.layoutParams ?: return
                layoutParams.height = width
                holder.itemView.layoutParams = layoutParams*/
            }
            is SquareVH -> {
                holder.bind(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type.ordinal
    }
}

class HorizontalVH(private val binding: ItemHorizontalBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Data) {
        binding.image.setImageResource(data.image)
        binding.name.text = data.name
    }
}

class VerticalVH(private val binding: ItemVerticalBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Data) {
        binding.image.setImageResource(data.image)
        binding.name.text = data.name
    }
}

class SquareVH(private val binding: ItemSquareBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Data) {
        binding.image.setImageResource(data.image)
        binding.name.text = data.name
    }
}