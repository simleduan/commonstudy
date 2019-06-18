package com.sime.invoke.annaotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)//成员变量 表示作用范围使用在类上
@Retention(RetentionPolicy.RUNTIME)//表示运行时可以通过反射机制获取
@Documented
public @interface FanService {
    String value() default "";
}
