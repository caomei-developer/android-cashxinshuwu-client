package com.xinshuwu.widget.easyrecyclerview;

import android.view.View;

import com.xinshuwu.widget.easyrecyclerview.adapter.RecyclerArrayAdapter;


public class CustomItemRecyclerClickListener implements RecyclerArrayAdapter.OnItemViewClickListener {
    RecyclerArrayAdapter.OnItemViewClickListener onItemClickListener;

    public CustomItemRecyclerClickListener(RecyclerArrayAdapter.OnItemViewClickListener listener) {
        onItemClickListener = listener;
    }

    @Override
    public void onItemViewClick(View view, int position) {
        if (!ListenerUtil.isMultipleClick()) {
            onItemClickListener.onItemViewClick(view, position);
        }
    }
}
