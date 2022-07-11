package com.hai.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.hai.entity.Book;
import com.hai.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hai
 * @date 2022/7/11
 * version 1.0
 */
@SuppressWarnings({"all"})
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;


    /**
     * 查询列表
     * @param currentPage 当前页
     * @param pageSize  每页有多少条数据
     * @return
     */
    @GetMapping("/list")
    public R<IPage<Book>> list (Integer currentPage, Integer pageSize) {
        return R.ok(bookService.getPage(currentPage, pageSize));
    }

    @PostMapping("/add")
    public R add (@RequestBody Book book) {

        boolean save = bookService.save(book);
        if (save) {
            return R.ok("添加成功");
        }
        return R.failed("添加失败");
    }

    /**
     * 修改
     * @param book
     * @return
     */
    @PutMapping("/update")
    public R update (@RequestBody Book book) {

        boolean update = bookService.updateById(book);
        if (update) {
            return R.ok("修改成功");
        }
        return R.failed("修改失败");
    }

    /**
     * 根据主键Id删对应数据
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public R delete (@RequestParam Long id) {
        boolean remove = bookService.removeById(id);
        if (remove) {
            return R.ok("删除成功");
        }
        return R.failed("删除失败");
    }








}
