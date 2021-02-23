package com.xinshuwu.recomend.adapter

import android.annotation.SuppressLint
import android.graphics.Rect
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
    var recommendHorizontalAdapter: BooksAdapter? = null


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
            recommendHorizontalAdapter = BooksAdapter(holder.itemView.context)
            if (position == 0 || position == 2 || position == 3 || position == 4 || position == 5) {
                holder.recyclerView.setLayoutManager(GridLayoutManager(holder.itemView.context, 4))
                recommendHorizontalAdapter!!.addAll(
                    BookUtil().convert(
                        list!![position].BOOKS.subList(
                            0,
                            8
                        )
                    )
                )
                holder.recyclerView.adapter = recommendHorizontalAdapter
                holder.recyclerView.adapter = recommendHorizontalAdapter

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
                recommendAdapter!!.setData(list!![position].BOOKS)
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


    class EvenItemDecoration(private val space: Int, private val column: Int) :
        RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            val position = parent.getChildAdapterPosition(view)
            // 每个span分配的间隔大小
            val spanSpace = space * (column + 1) / column
            // 列索引
            val colIndex = position % column
            // 列左、右间隙
            outRect.left = space * (colIndex + 1) - spanSpace * colIndex
            outRect.right = spanSpace * (colIndex + 1) - space * (colIndex + 1)
            // 行间距
            if (position >= column) {
                outRect.top = space
            }
        }
    }

}