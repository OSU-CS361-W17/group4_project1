package edu.oregonstate.cs361.battleship;
import java.util.*;

/**
 * Created by michaelhilton on 1/26/17.
 */
public class BattleshipModel {
    private Ship playerAC;
    private Ship playerBS;
    private Ship playerCR;
    private Ship playerDT;
    private Ship playerSB;
    private Ship aiAC;
    private Ship aiBS;
    private Ship aiCR;
    private Ship aiDT;
    private Ship aiSB;

    private List<point> player_hits;
    private List<point> player_nothit;
    private List<point> ai_hits;
    private List<point> ai_nothit;

    //initialize model
    public BattleshipModel(){
        //make a new initialize ship
        playerAC = new Ship("AircraftCarrier", "player");
        playerBS = new Ship("Battleship", "player");
        playerCR = new Ship("Cruiser", "player");
        playerDT = new Ship("Destoryer", "player");
        playerSB = new Ship("Submarine", "player");
        aiAC = new Ship("AircraftCarrier", "ai");
        aiBS = new Ship("Battleship", "ai");
        aiCR = new Ship("Cruiser", "ai");
        aiDT = new Ship("Destoryer", "ai");
        aiSB = new Ship("Submarine", "ai");

        player_hits = new ArrayList<point>();
        player_nothit = new ArrayList<point>();
        ai_hits = new ArrayList<point>();
        ai_nothit = new ArrayList<point>();
    }

    //Hit list, return list of points.
    public List<point> player_hited_point(){return player_hits;}
    public List<point> player_missed_point(){return player_nothit;}
    public List<point> player_hited_point(){return ai_hits;}
    public List<point> player_hited_point(){return ai_nothit;}


}
