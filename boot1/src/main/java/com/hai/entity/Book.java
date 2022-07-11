package com.hai.entity;

import lombok.Data;

/**
 * @author hai
 * @date 2022/7/11
 * version 1.0
 */
@SuppressWarnings({"all"})
@Data
public class Book {

    private Long id;

    private String name;

    private String  category;

    private String remark;
}
