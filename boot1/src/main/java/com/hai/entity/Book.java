package com.hai.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author hai
 * @date 2022/7/11
 * version 1.0
 */
@SuppressWarnings({"all"})
@Data
public class Book {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String name;

    private String  category;

    private String remark;
}
