package com.hai.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hai.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hai
 * @date 2022/7/11
 * version 1.0
 */
@SuppressWarnings({"all"})
@SpringBootTest
class IBookServiceTest {

    @Autowired
    private IBookService  bookService;

    @Test
    public void testBook() {

        List<Book> list = bookService.list();
        System.out.println(list);

        Page<Book> page = new Page<>(1, 3);
        bookService.page(page);

    }

}