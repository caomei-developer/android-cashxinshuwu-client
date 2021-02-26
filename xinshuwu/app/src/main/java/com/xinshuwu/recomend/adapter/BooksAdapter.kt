package com.xinshuwu.recomend.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.xinshuwu.R
import com.xinshuwu.base.InfoFlowInterface.LEVEL_TYPE
import com.xinshuwu.base.InfoFlowInterface.VERTICAL_TYPE
import com.xinshuwu.detail.BookDetailActivity
import com.xinshuwu.recomend.bean.RecommendBookInfoFlow
import com.xinshuwu.widget.easyrecyclerview.adapter.BaseViewHolder
import com.xinshuwu.widget.easyrecyclerview.adapter.RecyclerArrayAdapter

class BooksAdapter(context: Context) : RecyclerArrayAdapter<RecommendBookInfoFlow>(context) {

    override fun getViewType(position: Int): Int {
        return getItem(position).picShowType
    }

    override fun OnCreateViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): BaseViewHolder<RecommendBookInfoFlow>? {
        when (viewType) {
            LEVEL_TYPE -> {
                return LevelBooksViewHolder(parent!!, R.layout.recommend_item)
            }

            VERTICAL_TYPE -> {
                return VerticalBooksViewHolder(
                    parent!!, R.layout.recommend_horizontal_item
                )
            }
        }
        return null

    }

    class LevelBooksViewHolder(parent: ViewGroup, @LayoutRes res: Int) :
        BaseViewHolder<RecommendBookInfoFlow>(parent, res) {
        private var bookImage: ImageView
        private var bookName: TextView
        private var bookAuthor: TextView
        private var bookTypeDescribe: TextView

        init {
            bookImage = itemView.findViewById(R.id.book_image)
            bookName = itemView.findViewById(R.id.book_name)
            bookAuthor = itemView.findViewById(R.id.book_author)
            bookTypeDescribe = itemView.findViewById(R.id.book_type_desc)
        }


        override fun setData(data: RecommendBookInfoFlow?, position: Int) {
            super.setData(data, position)
            bookName.text = data!!.bookName
            bookAuthor.text = data!!.bookAuthor

            bookTypeDescribe.text = data!!.bookCategory + "\n" + data!!.content

            val roundedCorners = RoundedCorners(10)
            val options = RequestOptions.bitmapTransform(roundedCorners)
                .placeholder(ColorDrawable(Color.GRAY))//设置占位图
            Glide.with(itemView.context).load(data!!.bookImage)
                .apply(options)
                .into(bookImage)

        }
    }

    class VerticalBooksViewHolder(parent: ViewGroup, @LayoutRes res: Int) :
        BaseViewHolder<RecommendBookInfoFlow>(parent, res) {
        private var bookImage: ImageView
        private var bookName: TextView

        init {
            bookImage = itemView.findViewById(R.id.book_image)
            bookName = itemView.findViewById(R.id.book_name)
        }

        override fun setData(data: RecommendBookInfoFlow?, position: Int) {
            super.setData(data, position)

            bookName.text = data!!.bookName
            val roundedCorners = RoundedCorners(10)
            val options = RequestOptions.bitmapTransform(roundedCorners)
                .placeholder(ColorDrawable(Color.GRAY))//设置占位图
            Glide.with(itemView.context).load(data!!.bookImage)
                .apply(options)
                .into(bookImage)

            itemView.setOnClickListener {
                var intent = Intent(itemView.context, BookDetailActivity().javaClass)
                intent.putExtra("lm_id", data.lmId)
                intent.putExtra("b_id", data.getBookId())
                itemView.context.startActivity(intent)
            }
        }
    }

}