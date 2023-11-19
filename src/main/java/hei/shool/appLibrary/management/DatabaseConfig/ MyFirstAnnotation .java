package hei.shool.appLibrary.management.DatabaseConfig;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyFirstAnnotation {
    String value() default "Default value";
    int count() default 0;
}
