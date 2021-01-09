package com.xicheng.javabase.t00_base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * description
 *
 * @author xichengxml
 * @date 2021-01-09 08:05
 */
public class C03_Cloneable {


}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Student {

    private String name;

    private int age;
    // 会抛出异常CloneNotSupportedException
    public static void main(String[] args) throws Exception {
        Student student = new Student();
        student.clone();
    }
}
