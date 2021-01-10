package com.xicheng.javabase.t00_base;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * description
 *
 * @author xichengxml
 * @date 2021-01-09 07:14
 */
public class C001_Comparable {

    public static void main(String[] args) {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("信条", 8.9, 2020));
        movieList.add(new Movie("生活伴侣", 7.9, 2014));
        movieList.add(new Movie("心理迷宫", 7.2, 2016));
        movieList.add(new Movie("公主复仇记", 8.0, 2005));

        Collections.sort(movieList);
        System.out.println(movieList);
    }
}

@Data
class Movie implements Comparable<Movie> {

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

    public Movie() {
    }

    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public int compareTo(Movie o) {
        return this.year - o.year;
    }
}
