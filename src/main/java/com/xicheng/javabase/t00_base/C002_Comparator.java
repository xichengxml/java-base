package com.xicheng.javabase.t00_base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * description
 *
 * @author xichengxml
 * @date 2021-01-09 07:33
 */
public class C002_Comparator {

    public static void main(String[] args) {
        List<DefaultCompare> movieList = new ArrayList<>();
        movieList.add(new DefaultCompare("信条", 8.9, 2020));
        movieList.add(new DefaultCompare("生活伴侣", 7.9, 2014));
        movieList.add(new DefaultCompare("心理迷宫", 7.2, 2016));
        movieList.add(new DefaultCompare("公主复仇记", 8.0, 2005));

        Collections.sort(movieList, new DefaultCompare());
        System.out.println(movieList);
        Collections.sort(movieList, new NamingCompare());
        System.out.println(movieList);
        Collections.sort(movieList, new RatingCompare());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class DefaultCompare implements Comparator<DefaultCompare> {

    /**
     * 名称
     */
    private String name;

    /**
     * 评分
     */
    private double rating;

    /**
     * 发行日期
     */
    private int year;


    @Override
    public int compare(DefaultCompare o1, DefaultCompare o2) {
        return o1.getYear() - o2.getYear();
    }
}

class NamingCompare implements Comparator<DefaultCompare> {

    @Override
    public int compare(DefaultCompare o1, DefaultCompare o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class RatingCompare implements Comparator<DefaultCompare> {
    @Override
    public int compare(DefaultCompare o1, DefaultCompare o2) {
        if (o1.getRating() - o2.getRating() > 0) {
            return 1;
        } else if (o1.getRating() - o2.getRating() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
