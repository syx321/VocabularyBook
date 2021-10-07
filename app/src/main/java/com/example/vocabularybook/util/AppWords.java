package com.example.vocabularybook.util;

public class AppWords {
    public static final String SQL_CREATE_DATABASE = "create table note(English VARCHAR(256) PRIMARY KEY , Chinese VARCHAR(256), time varchar(20))";
    public static final String SQL_DELETE_DATABASE = "drop table note";
    public static final String SQL_SELECT_ALL = "select * from note";
}
