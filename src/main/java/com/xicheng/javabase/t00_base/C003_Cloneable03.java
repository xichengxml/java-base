package com.xicheng.javabase.t00_base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * description
 *
 * @author xichengxml
 * @date 2021-01-09 08:21
 */
public class C003_Cloneable03 {
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Student3 implements Cloneable {
    private String name;

    private int age;

    private Student student;

    public static void main(String[] args) throws Exception {
        Student3 student3 = new Student3("西城xml", 18, new Student("西城xml", 18));
        Student3 clone = (Student3) student3.clone();
        System.out.println(clone);
        student3.setAge(20);
        clone.getStudent().setAge(21);
        // 基本类型，深拷贝
        System.out.println(clone);
        student3.getStudent().setAge(20);
        // 引用类型，深拷贝
        System.out.println(clone);
        System.out.println(student3);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Assign the shallow copy to new reference variable student3
        Student3 student3 = (Student3) super.clone();

        student3.student = new Student();
        // Create a new object for the field c
        // and assign it to shallow copy obtained,
        // to make it a deep copy

        return student3;
    }
}


