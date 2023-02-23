package com.example.sportpractical.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.sportpractical.databinding.ItemPlayerBinding
import com.example.sportpractical.models.Player

class PlayerAdapter : ListAdapter<Player, PlayerAdapter.PlayerVH>(object : ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.nameFull == newItem.nameFull
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }
}) {

    inner class PlayerVH(val binding: ItemPlayerBinding) : ViewHolder(binding.root)

    var onClick: ((Player) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerVH {
        return PlayerVH(
            ItemPlayerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayerVH, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            val suffix: String = if (item.iscaptain == true && item.iskeeper == true)
                "(c & wk)"
            else if (item.iscaptain == true)
                "(c)"
            else if (item.iskeeper == true)
                "(wk)"
            else ""

            tvPlayerName.text = "${item.nameFull} $suffix"
            root.setOnClickListener {
                onClick?.invoke(item)
            }
        }
    }
}