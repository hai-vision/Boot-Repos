package com.hai.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hai.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hai
 * @date 2022/7/11
 * version 1.0
 */
@SuppressWarnings({"all"})
@Mapper
public interface BookDAO extends BaseMapper<Book> {
}
