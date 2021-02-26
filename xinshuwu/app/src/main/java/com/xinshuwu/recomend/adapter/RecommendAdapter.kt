package com.xinshuwu.recomend.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.xinshuwu.R
import com.xinshuwu.recomend.bean.RecommendBookInfoFlow
import com.xinshuwu.util.StringUtil


class RecommendAdapter : RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder>() {

    var books: List<RecommendBookInfoFlow>? = null
    var type: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        return RecommendViewHolder(View.inflate(parent.context, R.layout.recommend_item, null))
    }

    override fun getItemCount(): Int {
        return books!!.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        holder.bookName.text = books!![position].bookName
        holder.bookAuthor.text = books!![position].bookAuthor
        var desc: String? = null
        if (!StringUtil.isEmpty(books!![position].bookCategory)) {
            desc = books!![position].bookCategory
        }
        if (!StringUtil.isEmpty(desc) && !StringUtil.isEmpty(books!![position].content)) {
            holder.bookTypeDescribe.text =
                htmlTxt(holder.itemView.context, desc!!, books!![position].content)
        } else {
            holder.bookTypeDescribe.text = "暂无"
        }

        val roundedCorners = RoundedCorners(10)
        val options = RequestOptions.bitmapTransform(roundedCorners)
            .placeholder(ColorDrawable(Color.GRAY))//设置占位图
        Glide.with(holder.itemView.context).load(books!![position].bookImage)
            .apply(options)
            .into(holder.bookImage)
    }


    class RecommendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var bookImage = itemView.findViewById<ImageView>(R.id.book_image)
        var bookName = itemView.findViewById<TextView>(R.id.book_name)
        var bookAuthor = itemView.findViewById<TextView>(R.id.book_author)
        var bookTypeDescribe = itemView.findViewById<TextView>(R.id.book_type_desc)
    }


    fun setData(books: List<RecommendBookInfoFlow>) {
        this.books = books
        notifyDataSetChanged()
    }

    private fun htmlTxt(context: Context, desc: String, content: String): Spanned {
        return fromHtml(
            String.format(
                context.getString(R.string.book_type_desc),
                desc,
                content
            )
        )

    }

    private fun fromHtml(source: String): Spanned {
        return if (Build.VERSION.SDK_INT >= 24) Html.fromHtml(source, 0) else Html.fromHtml(source)
    }


}