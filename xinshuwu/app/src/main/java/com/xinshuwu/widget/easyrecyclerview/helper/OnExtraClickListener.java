package com.xinshuwu.widget.easyrecyclerview.helper;

import android.view.View;

public interface OnExtraClickListener<T> {
    public void onExtraClick(View view, T data, int pos);
}
