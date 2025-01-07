package com.example.cafeteria.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteria.R
import com.example.cafeteria.viewModels.MenuViewModel

class FoodAdapter(private val mList: List<Food>, private val menuViewModel: MenuViewModel) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_adapter_view, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val food = mList[position]

        when (food.type) {
            FoodTypes.MENJAR -> holder.productImage.setImageResource(R.drawable.pizza)
            FoodTypes.BEGUDA -> holder.productImage.setImageResource(R.drawable.bebida)
            FoodTypes.POSTRE -> holder.productImage.setImageResource(R.drawable.pastel)
        }

        // sets the image to the imageview from our itemHolder class
        holder.textViewNom.text = food.name

        // sets the text to the textview from our itemHolder class
        holder.textViewPrice.text = food.price.toString() + "€"

        holder.productLayout.setOnClickListener{
            menuViewModel.addProduct(food.id)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewNom: TextView = itemView.findViewById(R.id.textViewNom)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
        val productLayout: LinearLayout = itemView.findViewById(R.id.productLayout)
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
    }
}