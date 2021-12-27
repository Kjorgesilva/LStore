    package com.example.lstore.ui.cart

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.os.Parcelable
    import androidx.recyclerview.widget.RecyclerView
    import com.example.lstore.databinding.ActivityCartBinding
    import com.example.lstore.model.Product
    import java.io.Serializable


    class CartActivity : AppCompatActivity() {

        private val binding by lazy { ActivityCartBinding.inflate(layoutInflater) }
        private lateinit var products: ArrayList<Product>
        private lateinit var adapter: ProductAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(binding.root)


            products = ArrayList()

            val listItemCount: MutableList<Product> = intent.getSerializableExtra("list") as MutableList<Product>

            adapter = ProductAdapter(listItemCount, "Cart")
            binding.rvProduct.adapter = adapter


        }
    }