package com.example.uts_pizza_restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<PizzaItem>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private var itemClickListener: ((PizzaItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pizza_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            itemClickListener?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.tv_title_menu)
        private val textViewDescription: TextView = itemView.findViewById(R.id.tv_description_menu)
        private val pizzaImage: ImageView = itemView.findViewById(R.id.pizzaImage)

        fun bind(item: PizzaItem) {
            textView.text = item.name
            textViewDescription.text = item.description
            pizzaImage.setImageResource(item.image)
        }
    }


    fun setOnItemClickListener(listener: (PizzaItem) -> Unit) {
        itemClickListener = listener
    }
}
