package com.hai.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hai.entity.Book;

/**
 * @author hai
 * @date 2022/7/11
 * version 1.0
 */
@SuppressWarnings({"all"})
public interface IBookService extends IService<Book> {

    IPage<Book> getPage(Integer currentPage, Integer pageSize);
}
