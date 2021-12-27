package com.example.lstore.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lstore.R
import com.example.lstore.model.Product

class ProductAdapter(private val products: List<Product> = listOf(), private val activity: String) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    var cartList: ArrayList<Product> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.textProductName.text = product.productName
        holder.textFixedValue.text = product.productFixedValue
        holder.textOfferValue.text = product.productOfferValue
        holder.imageView.setImageResource(product.productImage)

        if (activity == "Main"){
            holder.ibDelete.visibility = View.GONE
            holder.ibAdd.visibility = View.VISIBLE
        }else {
            holder.ibDelete.visibility = View.VISIBLE
            holder.ibAdd.visibility = View.GONE
        }



        holder.ibAdd.setOnClickListener{
            if (!cartList.contains(product)){
                cartList.add(product)
            }
        }
    }

    override fun getItemCount(): Int = products.size

    fun getProductList(): ArrayList<Product>{
        return cartList
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textProductName = itemView.findViewById(R.id.txtProductName) as TextView
        val textFixedValue = itemView.findViewById(R.id.txtFixedValue) as TextView
        val textOfferValue = itemView.findViewById(R.id.txtOfferValue) as TextView
        val imageView = itemView.findViewById(R.id.imageView) as ImageView
        val ibAdd = itemView.findViewById(R.id.ib_add) as ImageButton
        val ibDelete = itemView.findViewById(R.id.ib_delete) as ImageButton
    }
}