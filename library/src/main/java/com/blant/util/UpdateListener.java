package com.blant.util;

/**
 * Created by hash on 2017/7/6.
 */

public interface UpdateListener {

    void onComplete();

    /**
     * @param current 当前秒数
     */
    void onTick(int current);
}
