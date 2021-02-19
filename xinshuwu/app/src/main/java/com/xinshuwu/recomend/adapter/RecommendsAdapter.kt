package com.xinshuwu.recomend.adapter

import android.annotation.SuppressLint
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xinshuwu.R
import com.xinshuwu.recomend.bean.LMLIST
import com.xinshuwu.util.DisplayUtils
import com.xinshuwu.widget.SpaceItemDecoration


class RecommendsAdapter : RecyclerView.Adapter<RecommendsAdapter.RecommendViewHolder>() {

    var list: List<LMLIST>? = null

    private var recommendAdapter: RecommendAdapter? = null
    var recommendHorizontalAdapter: RecommendHorizontalAdapter? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        return RecommendViewHolder(View.inflate(parent.context, R.layout.recommends_item, null))
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        if (list!![position].BOOKS.isNotEmpty()) {
            holder.bookCategoryTitle.text = list!![position].LMNAME
            recommendAdapter = RecommendAdapter()
            recommendHorizontalAdapter = RecommendHorizontalAdapter()
            if (position == 0) {
                holder.recyclerView.layoutManager = LinearLayoutManager(
                    holder.itemView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                recommendHorizontalAdapter!!.setData(list!![0].BOOKS)
                holder.recyclerView.adapter = recommendHorizontalAdapter
                val i = DisplayUtils.dip2px(holder.itemView.context, 15F)
                val rect = Rect(0, i, i, 0)

                val j = DisplayUtils.dip2px(holder.itemView.context, 10F)
                val firstAndLastRect = Rect(j, i, i, 0)

                holder.recyclerView.addItemDecoration(SpaceItemDecoration(rect, firstAndLastRect))
            } else {
                holder.recyclerView.layoutManager = LinearLayoutManager(
                    holder.itemView.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                recommendAdapter!!.setData(list!![position].BOOKS)
                holder.recyclerView.adapter = recommendAdapter

            }
            holder.categoryIcon.setImageResource(R.mipmap.icon_real_time)

        }

    }


    class RecommendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var bookCategoryTitle = itemView.findViewById<TextView>(R.id.category_title)
        var categoryIcon = itemView.findViewById<ImageView>(R.id.category_icon)

        var recyclerView = itemView.findViewById<RecyclerView>(R.id.recycler_view)!!
    }


    fun setData(books: List<LMLIST>) {
        this.list = books
        notifyDataSetChanged()
    }

}