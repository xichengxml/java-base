package com.xicheng.javabase.t00_base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * description
 *
 * @author xichengxml
 * @date 2021-01-09 08:10
 */
public class C04_Cloneable {

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Student2 implements Cloneable {

    private String name;

    private int age;

    private Student student;

    public static void main(String[] args) throws Exception {
        Student2 student2 = new Student2("西城xml", 18, new Student("西城xml", 18));
        Student2 clone = (Student2)student2.clone();
        System.out.println(clone);
        student2.setAge(20);
        // 基本类型，深拷贝
        System.out.println(clone);
        student2.getStudent().setAge(20);
        // 引用类型，浅拷贝
        System.out.println(clone);
    }
}
