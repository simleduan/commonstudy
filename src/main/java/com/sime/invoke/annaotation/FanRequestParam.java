package com.sime.invoke.annaotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})//作用在方法内部的声明
@Retention(RetentionPolicy.RUNTIME)//表示运行时可以通过反射机制获取
@Documented
public @interface FanRequestParam {
    String value() default "";
}
