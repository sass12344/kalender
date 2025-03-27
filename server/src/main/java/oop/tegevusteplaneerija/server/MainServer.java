package oop.tegevusteplaneerija.server;


import static java.lang.reflect.Array.set;
import static spark.Spark.*;
import com.google.gson.Gson;
import oop.tegevusteplaneerija.common.CalendarEvent;
import oop.tegevusteplaneerija.common.DatabaseManager;

import java.sql.SQLException;
import java.util.List;


public class MainServer {
    public static void main(String[] args) {
        String envPort = System.getenv("PORT"); // azure teenuses on olemas
        int portnumber = envPort != null ? Integer.parseInt(envPort) :  8080;
        port(portnumber);
        DatabaseManager dbm = new DatabaseManager("home/server.db");
        try {
            dbm.init();
        } catch (SQLException e) {
            e.printStackTrace();
            stop();
        }

        Gson gson = new Gson();

        get("/events", (req, res) -> {
            res.type("application/json");
            try {
                return dbm.printAll();
            } catch (SQLException e) {
                res.status(540);
                return e.getMessage();
            }
        }, gson::toJson);

        get("/tere", (req, res) -> {
           res.type("application/json");
           return "tere";
        }, gson::toJson);

        post("/events", (req, res) -> {
            res.type("application/json");
            try {
                // Parse the request body JSON into a CalendarEvent
                CalendarEvent event = gson.fromJson(req.body(), CalendarEvent.class);
                if (event == null) {
                    System.out.println("event on null");
                }
                dbm.insertEvent(event);
                res.status(201); // Created
                return event;
            } catch (SQLException e) {
                res.status(520);
                System.out.println(e.getStackTrace().toString());
                return e.getMessage();
            }
        }, gson::toJson);
    }

}
