package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import spark.Request;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

//I have added this comment to test (via: ABDUL)

public class Main {

    private static int Min = 1;
    private static int Max = 10;

    public static void main(String[] args) {
        //This will allow us to server the static pages such as index.html, app.js, etc.
        staticFiles.location("/public");

        //This will listen to GET requests to /model and return a clean new model
        get("/model", (req, res) -> newModel());
        //This will listen to POST requests and expects to receive a game model, as well as location to fire to
        post("/fire/:row/:col", (req, res) -> fireAt(req));
        //This will listen to POST requests and expects to receive a game model, as well as location to place the ship
        post("/placeShip/:id/:row/:col/:orientation", (req, res) -> placeShip(req));
    }

    //This function should return a new model
    static String newModel() {
        BattleshipModel game = new BattleshipModel();
        Gson gson = new Gson();
        game.computer_aircraftcarrier.setstart(new point(2,2));
        game.computer_aircraftcarrier.setend(new point(2,7));
        game.ccomputer_battleship.setstart(new point(2,8));
        game.computer_battleship.setend(new point(6,8));
        game.computer_cruiser.setstart(new point(4,1));
        game.computer_cruiser.setend(new point(4,4);
        game.computer_destoryer.setstart(new point(7,3));
        game.computer_destoryer.setend(new point(7,5));
        game.computer_submarine.setstart(new point(9,6));
        game.computer_submarine.setend(new point(9,8));

        String model = new String(gson.toJson(game))
        return model;
    }

    //This function should accept an HTTP request and deseralize it into an actual Java object.
    private static BattleshipModel getModelFromReq(Request req){
        String Request = req.body();
        Gson gson = new Gson();
        BattleshipModel ship = gson.fromJson(Request, BattleshipModel.class);
        return ship;
    }

    //This controller should take a json object from the front end, and place the ship as requested, and then return the object.
    private static String placeShip(Request req) {
        return "SHIP";
    }

    //Similar to placeShip, but with firing.
    private static String fireAt(Request req) {
        return null;
    }

}