package com.hai.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.hai.entity.Book;
import com.hai.entity.Query;
import com.hai.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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


    ///**
    // * 查询列表
    // * @param currentPage 当前页
    // * @param pageSize  每页有多少条数据
    // * @return
    // */
    //@GetMapping("/list")
    //public R<IPage<Book>> list (Integer currentPage, Integer pageSize) {
    //    //return R.ok(bookService.getPage(currentPage, pageSize));
    //}

    /**
     * 查询列表
     * 使用 Map接收GET请求的路径参数
     * @param currentPage 当前页
     * @param pageSize  每页有多少条数据
     * @return
     */
    @GetMapping("/list")
    public R<IPage<Book>> list (@RequestParam Map<String, Object> map) {
        //System.out.println(query);
        System.out.println(map);
        Integer currentPage = Integer.valueOf((String) map.get("currentPage"));
        Integer pageSize = Integer.valueOf((String) map.get("pageSize"));
        IPage<Book> page = bookService.getPage(currentPage, pageSize);
        return R.ok(page);

    }

    /**
     * 根据前端的数据，利用Book接收
     * @param book
     * @return
     */
    @PostMapping("/add")
    public R add (@RequestBody Book book) {

        System.out.println(book);
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

        //System.out.println(book);
        boolean update = bookService.updateById(book);
        if (update) {
            return R.ok("修改成功");
        }
        return R.failed("修改失败");
        //return null;
    }

    /**
     * 根据主键Id删对应数据
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public R delete (@RequestBody Book book) {
        System.out.println(book);
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.eq("name", book.getName());
        boolean remove = bookService.remove(qw);
        if (remove) {
            return R.ok("删除成功");
        }
        return R.failed("删除失败");

    }

    //@DeleteMapping("/delete/{id}")
    //public R delete (@PathVariable("id") Long id) {
    //    System.out.println(id);
    //    boolean remove = bookService.removeById(id);
    //    if (remove) {
    //        return R.ok("删除成功");
    //    }
    //    return R.ok("删除失败");
    //}








}
