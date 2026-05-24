package com.example.latihanrecyclerview.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanrecyclerview.R
import com.example.latihanrecyclerview.databinding.ItemListBinding
import com.example.latihanrecyclerview.model.ItemModel

class ItemAdapter(private val list: List<ItemModel>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        val context = holder.itemView.context

        if (position % 2 == 0) {
            holder.binding.cardContainer.setCardBackgroundColor(
                ContextCompat.getColor(context, R.color.white)
            )
        } else {
            holder.binding.cardContainer.setCardBackgroundColor(
                ContextCompat.getColor(context, R.color.green_pastel)
            )
        }

        holder.binding.tvTitle.text = item.title
        holder.binding.tvDesc.text = item.desc

        holder.binding.switchItem.setOnCheckedChangeListener(null)
        holder.binding.switchItem.isChecked = item.isChecked

        updateSwitchColor(holder)

        holder.binding.switchItem.setOnCheckedChangeListener { _, isChecked ->
            item.isChecked = isChecked
            updateSwitchColor(holder)

            val status = if (isChecked) "hidup" else "mati"
            Toast.makeText(context, "Switch $status pada item ${item.id}", Toast.LENGTH_SHORT).show()
        }

        holder.binding.btnAksi.setOnClickListener {
            Toast.makeText(context, "Tombol telah ditekan untuk item ${item.id}", Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Item telah ditekan untuk ${item.id}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateSwitchColor(holder: ViewHolder) {
        val context = holder.itemView.context
        val colorActive = ContextCompat.getColor(context, R.color.purple_500)
        val colorInactive = ContextCompat.getColor(context, R.color.grey_500)

        val trackColors = ColorStateList(
            arrayOf(
                intArrayOf(-android.R.attr.state_checked),
                intArrayOf(android.R.attr.state_checked)
            ),
            intArrayOf(colorInactive, colorActive)
        )
        holder.binding.switchItem.trackTintList = trackColors
    }

    override fun getItemCount(): Int = list.size
}