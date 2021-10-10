package com.example.vocabularybook.util;

public class AppWords {
    public static String SQL_CREATE_DATABASE =
            "create table note(English VARCHAR(256) PRIMARY KEY , Chinese VARCHAR(256), time varchar(20))";
    public static String SQL_DELETE_DATABASE = "delete from note where English = ?";
    public static String SQL_INSERT_DATABASE = "insert into note values(?,?,?)";
    public static String SQL_UPDATE_DATABASE = "update note set Chinese = ? where English = ?";
    public static String SQL_SELECT_ALL = "select * from note";
}
