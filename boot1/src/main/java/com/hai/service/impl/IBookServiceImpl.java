package com.hai.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hai.dao.BookDAO;
import com.hai.entity.Book;
import com.hai.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hai
 * @date 2022/7/11
 * version 1.0
 */
@SuppressWarnings({"all"})
@Service
public class IBookServiceImpl
        extends ServiceImpl<BookDAO, Book>
        implements IBookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        return bookDAO.selectPage(page, null);
    }
}
