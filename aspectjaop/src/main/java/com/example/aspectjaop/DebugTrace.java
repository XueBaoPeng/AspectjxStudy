package com.example.aspectjaop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @des: 性能检测的注解
 * @author: 薛宝鹏
 * @date: 2018/4/21 17:35
 */


@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD})
public @interface DebugTrace {
}
