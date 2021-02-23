package com.xinshuwu.util

import com.xinshuwu.recomend.bean.BOOKS
import com.xinshuwu.recomend.bean.RecommendBookInfoFlow

class BookUtil {
    fun convert(books: List<BOOKS>): MutableList<RecommendBookInfoFlow> {
        var newsBooks: MutableList<RecommendBookInfoFlow> = ArrayList()
        books.forEach {
            newsBooks.add(RecommendBookInfoFlow(it))
        }
        return newsBooks
    }
}