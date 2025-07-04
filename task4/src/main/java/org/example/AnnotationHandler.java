package org.example;


import java.lang.reflect.Method;

public class AnnotationHandler {
    public static void process(Object obj){
        if(obj.getClass().isAnnotationPresent(DeprecatedEx.class)){
            System.out.println(obj.getClass().getAnnotation(DeprecatedEx.class).message());
        }
        if(obj.getClass().getSuperclass().isAnnotationPresent(DeprecatedEx.class)){
            System.out.println(obj.getClass().getSuperclass().getAnnotation(DeprecatedEx.class).message());
        }
        for(Method method: obj.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(DeprecatedEx.class)){
                System.out.println(method.getAnnotation(DeprecatedEx.class).message());
            }
        }
    }
}
