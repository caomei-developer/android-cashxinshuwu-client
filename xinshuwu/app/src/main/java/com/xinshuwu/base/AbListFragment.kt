package com.xinshuwu.base

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.xinshuwu.R
import com.xinshuwu.widget.easyrecyclerview.CustomItemRecyclerClickListener
import com.xinshuwu.widget.easyrecyclerview.EasyRecyclerView
import com.xinshuwu.widget.easyrecyclerview.adapter.RecyclerArrayAdapter

abstract class AbListFragment<V : BaseView, P : BasePresenter<V>, M> : BaseMvpFragment<V, P>(),
    SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnLoadMoreListener,
    RecyclerArrayAdapter.OnItemViewClickListener, BaseView {
    private lateinit var recyclerView: EasyRecyclerView

    private lateinit var adapter: RecyclerArrayAdapter<M>

    private var alreadyToLastPage: Boolean = false

    private var page: Int = 0

    private var isRequesting: Boolean = false

    private lateinit var contentView: ViewGroup

    private lateinit var headerView: View

    private lateinit var footerView: View

    private var scrollY: Int = 0

    private lateinit var extraContainer: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = getRecyclerViewAdapter()
        setAdapterState()
    }

    protected fun setAdapterState() {
        adapter!!.apply {
            setNoMore(R.layout.view_nomore)
            setError(R.layout.view_error).setOnClickListener {
                adapter.resumeMore()
            }
        }
        adapter.setMore(R.layout.view_more, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (contentView == null) {
            contentView = if (getLayoutResId() == -1) {
                inflater.inflate(R.layout.fragment_list, null) as ViewGroup
            } else {
                inflater.inflate(getLayoutResId(), null) as ViewGroup
            }
            recyclerView = contentView.findViewById<View>(R.id.rv_products) as EasyRecyclerView
            if (hasRefresh()) {
                recyclerView.setRefreshListener(this)
            }
            recyclerView.setHeaderPrior(isHeaderPrior())
            var layoutManager = getLayoutManager()
            recyclerView.setLayoutManager(layoutManager)
            if (needProgress()) {
                recyclerView.setAdapterWithProgress(adapter)
            } else {
                recyclerView.adapter = adapter
            }

            if (getItemDecoration() != null) {
                recyclerView.addItemDecoration(getItemDecoration())
            }

            headerView = getHeaderView(recyclerView)!!

            if (headerView != null) {
                adapter.addHeader(object : RecyclerArrayAdapter.ItemView {
                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onCreateView(parent: ViewGroup?): View {
                        if (extraViewsListener != null) {
                            extraViewsListener!!.onHeaderAdded(headerView)
                        }
                        onHeaderAdded(headerView)
                        return headerView
                    }

                    override fun onBindView(headerView: View?) {
                    }

                })
            }

            footerView = getFooterView(recyclerView)!!

            if (footerView != null) {
                adapter.addFooter(object : RecyclerArrayAdapter.ItemView {
                    override fun onCreateView(parent: ViewGroup?): View {
                        if (extraViewsListener != null) {
                            extraViewsListener!!.onFooterAdded(footerView)
                        }
                        onFooterAdded(footerView)
                        return footerView
                    }

                    override fun onBindView(headerView: View?) {
                    }

                })
            }

            if (recyclerView.emptyView != null) {
                recyclerView.emptyView.setOnClickListener {
                    adapter.clear()
                    if (needProgress()) {
                        recyclerView.setAdapterWithProgress(adapter)
                        recyclerView.showProgress()
                    } else {
                        recyclerView.adapter = adapter
                    }
                    onClickErrorView(it)
                    loadData()
                }
            }

            adapter.setOnItemViewClickListener(CustomItemRecyclerClickListener(this))

            recyclerView.setOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    scrollStateChanged(recyclerView, newState)
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    scrolled(recyclerView, dx, dy)
                }

            })
        }
        extraContainer = contentView.findViewById(R.id.extra_container)
        initView()
        return contentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (needSetVisibleHintManually()) {
            setVisibleHint(userVisibleHint)
        }
    }

    fun setVisibleHint(isVisibleToUser: Boolean) {
        if (isVisibleToUser) {
            if (!isRequesting && !alreadyToLastPage && adapter.count <= 0) {
                loadData()
            }
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (view != null) {
            setVisibleHint(isVisibleToUser)
        }
    }

    protected fun initView() {

    }

    protected fun scrollStateChanged(recyclerView: RecyclerView, newState: Int) {}

    protected fun scrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        scrollY += dy
        if (recyclerView != null && recyclerView.computeVerticalScrollOffset() == 0) {
            scrollY = 0
        }
    }

    protected abstract fun loadData()

    protected fun onClickErrorView(view: View) {

    }

    protected fun onFooterAdded(footerView: View) {

    }

    fun getFooterView(parent: View): View? {
        return null
    }

    protected fun onHeaderAdded(headerView: View) {

    }

    fun getHeaderView(parent: View): View? {
        return null
    }

    protected fun getItemDecoration(): RecyclerView.ItemDecoration? {
        return null
    }

    fun needProgress(): Boolean {
        return true
    }

    protected abstract fun getLayoutManager(): RecyclerView.LayoutManager


    protected fun isHeaderPrior(): Boolean {
        return true
    }

    fun hasRefresh(): Boolean {
        return true
    }

    public fun getLayoutResId(): Int {
        return -1
    }

    protected abstract fun getRecyclerViewAdapter(): RecyclerArrayAdapter<M>

    fun onItemClick(position: Int) {

    }

    protected fun isRefreshing(): Boolean {
        return if (recyclerView == null) false else recyclerView.isRefreshing;
    }

    fun setRefreshing(isRefreshing: Boolean) {
        if (recyclerView != null) {
            recyclerView.isRefreshing = isRefreshing
        }
    }

    fun getPageSize(): Int {
        return 10
    }

    fun getMinSizeToShowFooter(): Int {
        return 6
    }

    override fun onRefresh() {
        page = 1
        alreadyToLastPage = false
        recyclerView.setRefreshingImmediately(true)
        loadData()
        if (activity is SwipeRefreshLayout.OnRefreshListener) {
            (activity as SwipeRefreshLayout.OnRefreshListener).onRefresh()
        }
    }

    override fun onLoadMore() {
        loadData()
    }

    override fun onItemViewClick(view: View?, position: Int) {
        onItemClick(position)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(msg: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private var extraViewsListener: ExtraViewsListener? = null

    fun setExtraViewsListener(extraViewsListener: ExtraViewsListener) {
        this.extraViewsListener = extraViewsListener
    }

    interface ExtraViewsListener {
        fun onHeaderAdded(headerView: View)

        fun onFooterAdded(footerView: View)
    }
}