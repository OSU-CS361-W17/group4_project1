package edu.oregonstate.cs361.battleship;
import java.util.*;

/**
 * Created by michaelhilton on 1/26/17.
 * Edited by George Mistkawi
 */
public class BattleshipModel {
    private static int MAX = 10;
    private static int MIN = 1;
    //player ships
    private Ship aircraftCarrier;
    private Ship battleship;
    private Ship cruiser;
    private Ship destroyer;
    private Ship submarine;

    //computer ships
    private Ship computer_aircraftCarrier;
    private Ship computer_battleship;
    private Ship computer_cruiser;
    private Ship computer_destroyer;
    private Ship computer_submarine;

    //lists of points
    private ArrayList<Point> playerHits;
    private ArrayList<Point> playerMisses;
    private ArrayList<Point> computerHits;
    private ArrayList<Point> computerMisses;

    //initialize model
    public BattleshipModel() {
        //make a new initialize ship
        this.aircraftCarrier = new Ship("AircraftCarrier", 5, new Point(0, 0), new Point(0, 0));
        this.battleship = new Ship("Battleship", 4, new Point(0, 0), new Point(0, 0));
        this.cruiser = new Ship("Cruiser", 3, new Point(0, 0), new Point(0, 0));
        this.destroyer = new Ship("Destroyer", 2, new Point(0, 0), new Point(0, 0));
        this.submarine = new Ship("Submarine", 2, new Point(0, 0), new Point(0, 0));
        this.computer_aircraftCarrier = new Ship("Computer_AircraftCarrier", 5, new Point(2, 2), new Point(2, 7));
        this.computer_battleship = new Ship("Computer_Battleship", 4, new Point(2, 8), new Point(6, 8));
        this.computer_cruiser = new Ship("Computer_Cruiser", 3, new Point(4, 1), new Point(4, 4));
        this.computer_destroyer = new Ship("Computer_Destroyer", 2, new Point(7, 3), new Point(7, 5));
        this.computer_submarine = new Ship("Computer_Submarine", 2, new Point(9, 6), new Point(9, 8));


        this.playerHits = new ArrayList<Point>();
        this.playerMisses = new ArrayList<Point>();
        this.computerHits = new ArrayList<Point>();
        this.computerMisses = new ArrayList<Point>();
    }

    public boolean placeShip(String id, int row, int col, String dir) {
        //determine ship to change
        Ship ship = shipById(id);
        int xEnd, yEnd;
        if (dir.equals("horizontal")) {
            xEnd = row + ship.getLength();
            yEnd = col;
        } else {
            xEnd = row;
            yEnd = col + ship.getLength();
        }

        //determine if change is valid
        if (row < this.MIN || col < this.MIN
                || xEnd > this.MAX || yEnd > this.MAX || overlapLoop(ship)) {
            return false;
        }

        ship.setStart(row, col);
        ship.setEnd(xEnd, yEnd);

        return true;
    }

    public boolean fireShot(Point p) {
        //determines if point is valid
        for (Point node: computerHits)
        {
            if (p.samePointCheck(node)) {
                return false;
            }
        }
        for (Point node: computerMisses) {
            if (p.samePointCheck(node)) {
                return false;
            }
        }
        if (p.getAcross() > this.MAX || p.getAcross() < this.MIN
                || p.getDown() > this.MAX || p.getDown() < this.MIN) {
            return false;
        }

        //if hitCheck misses, is true, continue to next ship
        //if all are misses, add to playerMisses
        if (!(!hitCheck(p, computer_aircraftCarrier)
                || !hitCheck(p, computer_battleship)
                || !hitCheck(p, computer_cruiser)
                || !hitCheck(p, computer_destroyer)
                || !hitCheck(p, computer_submarine))) {
            computerMisses.add(p);
        } else {
            computerHits.add(p);
        }

        return true;
    }

    public void computer_fireShot() {
        boolean found = true;
        Random rn = new Random();
        Point p = new Point (rn.nextInt(this.MAX) + this.MIN, rn.nextInt(this.MAX) + this.MIN);
        //generates a point, tests if the point already exists in hits or
        //misses, if not move on and check if the shot is a hit or miss
        while (!found) {

            for (Point node: playerHits)
            {
                if (p.samePointCheck(node)) {
                    found = false;
                }
            }
            for (Point node: playerMisses) {
                if (p.samePointCheck(node)) {
                    found = false;
                }
            }
        }

        if (!(!hitCheck(p, aircraftCarrier)
                || !hitCheck(p, battleship)
                || !hitCheck(p, cruiser)
                || !hitCheck(p, destroyer)
                || !hitCheck(p, submarine))) {
            playerMisses.add(p);
        } else {
            playerHits.add(p);
        }
    }

    //checks if its a hit or a miss
    private boolean hitCheck(Point p, Ship s) {
        if (p.getAcross() == s.getStart().getAcross()
                && p.getDown() >= s.getStart().getDown()
                && p.getDown() <= s.getEnd().getDown()) {
            return true;
        }

        else if (p.getDown() == s.getStart().getDown()
                && p.getAcross() >= s.getStart().getAcross()
                && p.getAcross() <= s.getEnd().getAcross()) {
            return true;
        }

        return false;
    }

    //returns ship object based on the id given in url
    private Ship shipById(String id) {
        Ship ship = null;
        switch(id) {
            case "aircraftCarrier":
                ship = this.aircraftCarrier;
                break;
            case "battleship":
                ship = this.battleship;
                break;
            case "cruiser":
                ship = this.cruiser;
                break;
            case "destroyer":
                ship = this.destroyer;
                break;
            case "submarine":
                ship = this.submarine;
                break;
        }

        return ship;
    }

    //false if there is an overlap with the new ship
    private boolean overlapLoop(Ship s) {
        return aircraftCarrier.overlapTest(s) || battleship.overlapTest(s) || cruiser.overlapTest(s) || destroyer.overlapTest(s) || submarine.overlapTest(s);
    }
}
