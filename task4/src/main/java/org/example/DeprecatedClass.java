package org.example;

@DeprecatedEx(message = "Внимание: класс 'DeprecatedClass' устарел. Альтернатива: 'NewClass'")
public class DeprecatedClass extends SuperDeprecatedClass {
    @DeprecatedEx(message = "Внимание: метод 'deprecatedMethod' устарел. Альтернатива: 'newMethod'")
    public void deprecatedMethod(){}
    @DeprecatedEx(message = "Внимание: метод 'oldMethod' устарел. Альтернатива: 'newMethod'")
    public void oldMethod(){}
    public void newMethod(){}
}
