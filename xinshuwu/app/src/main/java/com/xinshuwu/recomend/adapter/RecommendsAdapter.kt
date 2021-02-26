package com.xinshuwu.recomend.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xinshuwu.R
import com.xinshuwu.recomend.bean.LMLIST
import com.xinshuwu.util.BookUtil
import com.xinshuwu.util.DisplayUtils
import com.xinshuwu.widget.SpaceItemDecoration
import com.xinshuwu.widget.easyrecyclerview.EasyNoRefreshRecyclerView


class RecommendsAdapter : RecyclerView.Adapter<RecommendsAdapter.RecommendViewHolder>() {

    var list: List<LMLIST>? = null

    private var recommendAdapter: RecommendAdapter? = null
    var booksAdapter: BooksAdapter? = null


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
            booksAdapter = BooksAdapter(holder.itemView.context)
            if (position == 0 || position == 2 || position == 3 || position == 4 || position == 5) {
                holder.recyclerView.setLayoutManager(GridLayoutManager(holder.itemView.context, 4))
                booksAdapter!!.addAll(
                    BookUtil().convert(
                        list!![position].BOOKS.subList(
                            0,
                            8
                        )
                        , list!![position].LMID
                    )
                )
                holder.recyclerView.adapter = booksAdapter
                holder.recyclerView.addItemDecoration(
                    SpaceItemDecoration(
                        DisplayUtils.dip2px(
                            holder.itemView.context,
                            10f
                        )
                    )
                )

            } else {
                holder.recyclerView.setLayoutManager(
                    LinearLayoutManager(
                        holder.itemView.context,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                )
                recommendAdapter!!.setData(
                    BookUtil().convert(
                        list!![position].BOOKS,
                        list!![position].LMID
                    )
                )
                holder.recyclerView.adapter = recommendAdapter

            }
            holder.categoryIcon.setImageResource(R.mipmap.icon_real_time)
        }

    }

    class RecommendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var bookCategoryTitle = itemView.findViewById<TextView>(R.id.category_title)
        var categoryIcon = itemView.findViewById<ImageView>(R.id.category_icon)

        var recyclerView =
            itemView.findViewById<EasyNoRefreshRecyclerView>(R.id.eas_recycler_view)!!
    }

    fun setData(books: List<LMLIST>) {
        this.list = books
        notifyDataSetChanged()
    }

}