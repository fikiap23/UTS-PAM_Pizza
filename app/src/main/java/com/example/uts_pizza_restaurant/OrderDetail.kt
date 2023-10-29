package com.example.uts_pizza_restaurant

import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderDetail : AppCompatActivity() {
    companion object {
        const val CUSTOMER_NAME_EXTRA = "com.example.uts_pizza_restaurant.extra.CUSTOMER_NAME"
        const val SELECTED_OPTION_EXTRA = "com.example.uts_pizza_restaurant.extra.SELECTED_OPTION"
    }

    // Inisialisasi view yang akan digunakan
    private lateinit var orderDetailView: TextView
    private lateinit var orderMessageDoneView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        initializeViews()
        displayOrderDetails()
    }

    // Memisahkan inisialisasi view ke metode terpisah
    private fun initializeViews() {
        orderDetailView = findViewById(R.id.detail)
        orderMessageDoneView = findViewById(R.id.order_message)
    }

    // Memisahkan logika menampilkan detail pesanan ke metode terpisah
    private fun displayOrderDetails() {
        val customerName = intent.getStringExtra(CUSTOMER_NAME_EXTRA) ?: ""
        val store = intent.getStringExtra(SELECTED_OPTION_EXTRA)

        val orderDetailText = """
            $customerName
            Store: $store
            Pepperoni Pizza sudah dipesan
        """.trimIndent()

        val orderMessageText = "Terima kasih $customerName sudah memesan di toko kami, pesanan Pepperoni Pizza anda dikirim menggunakan Fast Delivery"

        orderDetailView.text = orderDetailText
        orderMessageDoneView.text = orderMessageText
    }
}
