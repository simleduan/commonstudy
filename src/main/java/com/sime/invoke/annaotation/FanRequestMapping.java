package com.sime.invoke.annaotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})//类和方法都可以使用
@Retention(RetentionPolicy.RUNTIME)//表示运行时可以通过反射机制获取
@Documented
public @interface FanRequestMapping {
    String value() default "";
}
