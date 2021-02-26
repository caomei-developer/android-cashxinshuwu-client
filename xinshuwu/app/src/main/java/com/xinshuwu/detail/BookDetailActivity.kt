package com.xinshuwu.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.xinshuwu.R
import com.xinshuwu.base.BaseMvpActivity
import com.xinshuwu.detail.bean.BookDetail
import com.xinshuwu.detail.contract.BookDetailContract
import com.xinshuwu.detail.presenter.BookDetailPresenter
import com.xinshuwu.net.APIConstant
import com.xinshuwu.util.SignatureUtil
import com.xinshuwu.util.StringUtil
import kotlinx.android.synthetic.main.novel_detail_activity.*

class BookDetailActivity : BaseMvpActivity<BookDetailContract.View, BookDetailPresenter>(),
    BookDetailContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.novel_detail_activity)


        mPresenter = BookDetailPresenter()
        mPresenter!!.attachView(this)

        var time = java.lang.Long.valueOf(System.currentTimeMillis())
        var lmId = intent.getStringExtra("lm_id")
        var bId = intent.getIntExtra("b_id", 0).toString()

        val param = SignatureUtil().bookindex(
            APIConstant().APP_ANDROID,
            time,
            bId,
            lmId,
            APIConstant().UID,
            APIConstant().APP_URL_GET_HTTP_MODE,
            APIConstant().FZ_BASE_URL + APIConstant().FZ_BOOK_INDEX_URL
        )


        mPresenter!!.BookDetaolPresenter(
            time,
            param, bId, lmId, "0", APIConstant().UID
        )

    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(msg: String?) {
    }

    override fun onSuccess(bookDetail: BookDetail) {
        Glide.with(this).load(bookDetail.COVERURL).into(book_image)
        book_name.text = bookDetail.BNAME
        book_author.text = bookDetail.ANAME
        book_type_number_word.text =
            bookDetail.BTNAME + " " + StringUtil.wordConversion(bookDetail.WORDNUM)


    }

    override fun hasToolbar(): Boolean {
        return true
    }

}