package edu.oregonstate.cs361.battleship;
import java.util.*;

/**
 * Created by michaelhilton on 1/26/17.
 */
public class BattleshipModel {
    private Ship aircraftcarrier;
    private Ship battleship;
    private Ship cruiser;
    private Ship destoryer;
    private Ship submarine;
    private Ship computer_submarine;
    private Ship computer_battleship;
    private Ship computer_cruiser;
    private Ship computer_destoryer;
    private Ship computer_aircraftcarrier;

    private List<point> player_hits;
    private List<point> player_nothit;
    private List<point> ai_hits;
    private List<point> ai_nothit;

    //initialize model
    public BattleshipModel(){
        //make a new initialize ship
        aircraftcarrier = new Ship("AircraftCarrier"");
        battleship = new Ship("Battleship");
        cruiser = new Ship("Cruiser");
        destoryer = new Ship("Destoryer");
        submarine = new Ship("Submarine");
        computer_aircraftcarrier = new Ship("AircraftCarrier");
        computer_battleship = new Ship("Battleship");
        computer_cruiser = new Ship("Cruiser");
        computer_destoryer = new Ship("Destoryer");
        computer_submarine = new Ship("Submarine");

        playerHits = new ArrayList<point>();
        playerMisses = new ArrayList<point>();
        computerHits = new ArrayList<point>();
        computerMisses = new ArrayList<point>();
    }

    //Hit list, return list of points.
    public List<point> player_hited_point(){return playerHits;}
    public List<point> player_missed_point(){return playerMisses;}
    public List<point> player_hited_point(){return computerHits;}
    public List<point> player_hited_point(){return computerMisses;}


        public Ship getaircraftcarrier(){return aircraftcarrier;}
        public Ship getbattleship(){return battleship;}
        public Ship getcruiser(){return cruiser;}
        public Ship getdestoryer(){return destoryer;}
        public Ship getsubmarine(){return submarine;}
        public Ship getcomputer_aircraftcarrier(){return computer_aircraftcarrier;}
        public Ship getcomputer_battleship(){return computer_battleship;}
        public Ship getcomputer_cruiser(){return computer_cruiser;}
        public Ship getcomputer_destoryer(){return computer_destoryer;}
        public Ship getcomputer_submarine(){return computer_submarine;}


}
