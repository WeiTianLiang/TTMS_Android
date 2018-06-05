package com.example.wtl.ttms_hdd.HDDMain.model;

/**
 * 数据信息
 * Created by WTL on 2018/6/5.
 */

public class FileModel implements IFile {

    private int film_head;
    private String film_name;
    private String film_acters;
    private String average_score;

    public FileModel(int film_head,String film_name,String film_acters,String average_score) {
        this.film_head = film_head;
        this.film_name = film_name;
        this.film_acters = film_acters;
        this.average_score = average_score;
    }

    public String getAverage_score() {
        return average_score;
    }

    public int getFilm_head() {
        return film_head;
    }

    public String getFilm_acters() {
        return film_acters;
    }

    public String getFilm_name() {
        return film_name;
    }

}
