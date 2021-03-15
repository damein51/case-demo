package com.zlsd.damein.controller.limit;

/**
 * @program: damein
 * @description: 令牌桶
 * @author: lidongmin
 * @create: 2021-03-11 18:07
 */
public class TokenBucket {

    /**
     * 时间
     */
    private long time;
    /**
     * 总量
     */
    private Double total;
    /**
     * token 放入速度
     */
    private Double rate;
    /**
     * 当前总量
     */
    private Double nowSize;


    public boolean limit() {
        long now = System.currentTimeMillis();
        nowSize = Math.min(total, nowSize + (now - time) * rate);
        time = now;
        if (nowSize < 1) {
            // 桶里没有token
            return false;
        } else {
            // 存在token
            nowSize -= 1;
            return true;
        }
    }
}