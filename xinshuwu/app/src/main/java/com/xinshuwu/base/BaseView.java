package com.xinshuwu.base;

import autodispose2.AutoDisposeConverter;

public interface BaseView {
    void showLoading();
    void hideLoading();
    void onError(String msg);
    <T>AutoDisposeConverter<T> bindAutoDispose();
}
