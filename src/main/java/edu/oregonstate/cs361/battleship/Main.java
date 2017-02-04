package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import spark.Request;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

//I have added this comment to test (via: ABDUL)

public class Main {

    public static void main(String[] args) {
        //This will allow us to server the static pages such as index.html, app.js, etc.
        staticFiles.location("/public");

        //This will listen to GET requests to /model and return a clean new model
        get("/model", (req, res) -> newModel());
        //This will listen to POST requests and expects to receive a game model, as well as location to firze to
        post("/fire/:row/:col", (req, res) -> fireAt(req));
        //This will listen to POST requests and expects to receive a game model, as well as location to place the ship
        post("/placeShip/:id/:row/:col/:orientation", (req, res) -> placeShip(req));
    }

    //This function should return a new model
    private static String newModel() {
        BattleshipModel model = new BattleshipModel();
        return getJson(model);
    }

    //Takes a model converts it to json using gson
    private static String getJson(BattleshipModel m) {
        Gson gson = new Gson();
        String model = new String(gson.toJson(m));
        return model;
    }

    //This function should accept an HTTP request and deseralize it into an actual Java object.
    private static BattleshipModel getModelFromReq(Request req){
        String Request = req.body();
        Gson gson = new Gson();
        BattleshipModel ship =  gson.fromJson(Request, BattleshipModel.class);
        return ship;
    }

    //This controller should take a json object from the front end, and place the ship as requested, and then return the object.
    private static String placeShip(Request req) {
        BattleshipModel model = getModelFromReq(req);

        //pull data from request
        String id = req.params("id");
        String orientation = req.params("orientation");
        int row = Integer.parseInt(req.params("row"));
        int col = Integer.parseInt(req.params("col"));

        //runs placeShip, catches if there is an error
        if(!model.placeShip(id, row, col, orientation)) {
            //error check needed
         }

        Gson gson = new Gson();
        String json = gson.toJson(model);
        return json;
    }

    //Similar to placeShip, but with firing.
    private static String fireAt(Request req) {
        //grab the target
        int row = Integer.parseInt(req.params("row"));
        int col = Integer.parseInt(req.params("col"));
        Point target = new Point(row, col);

        //grab the model
        BattleshipModel model = getModelFromReq(req);

        //if target is viable, computer shoots
        if(model.fireShot(target)) {
            model.computer_fireShot();
        }

        return getJson(model);
    }
}
