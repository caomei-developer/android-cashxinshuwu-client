package com.xinshuwu.recomend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xinshuwu.R
import com.xinshuwu.base.BaseMvpfragment
import com.xinshuwu.net.APIConstant
import com.xinshuwu.recomend.bean.LMLIST
import com.xinshuwu.recomend.contract.RecommendContract
import com.xinshuwu.recomend.presenter.RecommendPresenter
import com.xinshuwu.util.SignatureUtil


class RecommendFragment : BaseMvpfragment<RecommendContract.View, RecommendPresenter>(),
    RecommendContract.View {
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
        mPresenter = RecommendPresenter()
        mPresenter!!.attachView(this)
        parameters()
    }


    fun parameters() {
        val timestamp = System.currentTimeMillis()

        val param = SignatureUtil().elitebook(
            APIConstant().APP_ANDROID,
            timestamp,
            APIConstant().FU_JING_XUAN,
            APIConstant().UID,
            APIConstant().APP_URL_GET_HTTP_MODE,
            APIConstant().FZ_BASE_URL + APIConstant().FZ_HOME_URL
        )

        mPresenter!!.RecommendsPresenter(
            timestamp.toString(), param, APIConstant().FU_JING_XUAN, APIConstant().UID, "0",
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


    }

}