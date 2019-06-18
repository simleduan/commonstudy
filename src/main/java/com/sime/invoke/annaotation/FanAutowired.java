package com.sime.invoke.annaotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)//成员变量
@Retention(RetentionPolicy.RUNTIME)//表示运行时可以通过反射机制获取
@Documented
public @interface FanAutowired {
    String value() default "";
}
