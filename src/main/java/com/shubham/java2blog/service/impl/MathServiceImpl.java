package com.shubham.java2blog.service.impl;

import com.shubham.java2blog.service.MathService;

/**
 * @author : Shubham Aggarwal
 * @since : 15/09/17
 */
public class MathServiceImpl implements MathService {

    public long doubleLong(long num) {
        return 2 * num;
    }

    public long tripleLong(long num) {
        return 3 * num;
    }

    public long addition(long... nums) {

        int sum = 0;

        for (long a : nums)
            sum += a;

        return sum;
    }
}
