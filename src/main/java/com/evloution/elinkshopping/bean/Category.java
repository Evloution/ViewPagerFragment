package com.evloution.elinkshopping.bean;

import android.os.Bundle;

import com.evloution.elinkshopping.R;

/**
 * @Description：
 * @Author： Evloution_
 * @Date： 2019-12-12
 * @Email： 15227318030@163.com
 */
public class Category {
    private String title;
    private boolean isShow = true;

    public Category(String title) {
        this(title,true);
    }
    public Category(String title, boolean isShow) {
        this.title = title;
        this.isShow = isShow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
