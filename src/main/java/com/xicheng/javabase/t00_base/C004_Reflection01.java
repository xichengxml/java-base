package com.xicheng.javabase.t00_base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @see <a href="https://www.geeksforgeeks.org/reflection-in-java/"></a>
 */
public class C004_Reflection01 {

    public static void main(String[] args) throws Exception {
        User user = new User();
        Class<? extends User> userClass = user.getClass();

        // 看一下获取的构造方法是哪个 -- 无参
        Constructor<? extends User> constructor = userClass.getConstructor();
        System.out.println(Arrays.toString(constructor.getParameterTypes()));

        // 看一下能获取到哪些方法
        Method[] methods = userClass.getMethods();
        System.out.println(Arrays.toString(methods));

        Method method02 = userClass.getDeclaredMethod("method02", int.class);
        method02.invoke(user, 18);

        Field name = userClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user, "xichengxml");
        Method method01 = userClass.getDeclaredMethod("method01");
        method01.invoke(user);

        Method method03 = userClass.getDeclaredMethod("method03");
        method03.setAccessible(true);
        method03.invoke(user);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {

    private String name;

    public void method01() {
        System.out.println("The name is：" + name);
    }

    public void method02(int age) {
        System.out.println("The age is: " + age);
    }

    private void method03() {
        System.out.println("This is private method");
    }
}