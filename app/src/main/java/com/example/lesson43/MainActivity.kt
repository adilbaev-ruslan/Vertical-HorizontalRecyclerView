package com.example.lesson43

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter: MyAdapter = MyAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setData()
    }

    private fun setData() {
        val models: MutableList<ListItem> = mutableListOf()
        for (i in 1..100) {
            if (i % 5 == 0) {
                val reklama = Ads(ListItem.ADS_TYPE, "", "")
                models.add(reklama)
            } else {
                var lists: MutableList<Post> = mutableListOf()
                for (i in 1..5) {
                    val list = Post("", "", "")
                    lists.add(list)
                }
                val postItem = VerticalPost(ListItem.POST_TYPE, lists)
                models.add(postItem)
            }
        }
        adapter.models = models
    }
}