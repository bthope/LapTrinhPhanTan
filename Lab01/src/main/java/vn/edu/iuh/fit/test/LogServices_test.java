package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.entities.Log;
import vn.edu.iuh.fit.services.LogServices;

import java.sql.Timestamp;
import java.util.Date;

public class LogServices_test {
    public static void main(String[] args) {
        Date date = new Date();

        Log log = new Log("bang", new Timestamp(date.getTime()),new Timestamp(date.getTime()),"Oke");

        LogServices.insertLog(log);

        LogServices.getLogs().forEach(System.out::println);
    }
}
