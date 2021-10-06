package com.example.vocabularybook.util;

public class AppWords {
    public static final String SQL_CREATE_DATABASE = "create table note(id INTEGER PRIMARY KEY AUTOINCREMENT, English VARCHAR(256), Chinese VARCHAR(256), time varchar(20))";
    public static final String SQL_SELECT_ALL = "select * from note";
}
