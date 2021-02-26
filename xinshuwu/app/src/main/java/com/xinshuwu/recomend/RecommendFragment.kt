package com.xinshuwu.recomend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.xinshuwu.R
import com.xinshuwu.base.BaseMvpFragment
import com.xinshuwu.net.APIConstant
import com.xinshuwu.recomend.adapter.RecommendsAdapter
import com.xinshuwu.recomend.bean.LMLIST
import com.xinshuwu.recomend.contract.RecommendContract
import com.xinshuwu.recomend.presenter.RecommendPresenter
import com.xinshuwu.util.SignatureUtil
import kotlinx.android.synthetic.main.recommend_fragment.*


class RecommendFragment : BaseMvpFragment<RecommendContract.View, RecommendPresenter>(),
    RecommendContract.View {
    private var recommendsAdapter: RecommendsAdapter? = null


    fun newInstance(): RecommendFragment {

        val args = Bundle()

        val fragment = RecommendFragment()
        fragment.arguments = args
        return fragment
    }

    override fun getUserVisibleHint(): Boolean {
        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recommend_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recommendsAdapter = RecommendsAdapter()
        recycler_view.setLayoutManager(LinearLayoutManager(activity))
        mPresenter = RecommendPresenter()
        mPresenter!!.attachView(this)
        parameters()
    }


    private fun parameters() {
        val timestamp = java.lang.Long.valueOf(System.currentTimeMillis())

        val param = SignatureUtil().elitebook(
            APIConstant().APP_ANDROID,
            timestamp,
            APIConstant().FU_JING_XUAN,
            APIConstant().UID,
            APIConstant().APP_URL_GET_HTTP_MODE,
            APIConstant().FZ_BASE_URL + APIConstant().FZ_HOME_URL
        )

        mPresenter!!.RecommendsPresenter(
            timestamp, param, APIConstant().FU_JING_XUAN, APIConstant().UID, "0",
            "", "", "", "0"
        )
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(msg: String?) {
    }

    override fun onSuccess(lmlist: List<LMLIST>) {
        recommendsAdapter!!.setData(list(lmlist))
        recycler_view.adapter = recommendsAdapter
    }


    fun list(lmlist: List<LMLIST>): List<LMLIST> {
        var newListf: MutableList<LMLIST> = ArrayList()
        lmlist.forEach {
            if (it.BOOKS != null && it.BOOKS.isNotEmpty()) {
                newListf.add(it)
            }
        }
        return newListf
    }


}