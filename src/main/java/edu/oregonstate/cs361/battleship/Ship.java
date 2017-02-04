package edu.oregonstate.cs361.battleship;

//Ship class for Ship.
public class Ship{
    private String name;
    private int length;
    private Point start;
    private Point end;

    //constructors
    public Ship() { }
    public Ship(String n, int l, Point s, Point e) {
        this.name = n;
        this.length = l;
        this.start = s;
        this.end = e;
    }

    //getters
    public String getName() { return this.name; }
    public int getLength() { return this.length; }
    public Point getStart() { return this.start; }
    public Point getEnd() { return this.end; }

    //setters
    public void setName(String n) { this.name = n; }
    public void setLength(int l) { this.length = l; }
    public void setStart(int x, int y) { this.start = new Point(x,y); }
    public void setEnd(int x, int y) { this.end = new Point(x,y); }

    //returns false if there is an overlap
    public boolean overlapTest(Ship s) {
        //checks for overlap check of same boat
        if (s.getName() == this.name) {
            return true;
        }
        //checks if both lines horizantal and overlapping
        if (s.isHorizantal() == true && this.isHorizantal() == true
                && s.getEnd().getDown() == this.start.getDown()
                && s.getEnd().getAcross() >= this.start.getAcross()) {
            return false;
        }
        //checks if both lines vertical and overlapping
        else if (s.isHorizantal() == false && this.isHorizantal() == false
                && s.getEnd().getAcross() == this.start.getAcross()
                && s.getEnd().getDown() >= this.start.getDown()) {
            return false;
        }
        //checks if lines are perpendicular and overlapping
        else if (s.getEnd().getAcross() >= this.start.getAcross()
                && s.getEnd().getAcross() <= this.end.getAcross()
                && s.getStart().getDown() <= this.start.getDown()
                && s.getEnd().getDown() >= this.start.getDown()) {
            return false;
        }

        return true;
    }

    public boolean isHorizantal() {
        if (start.getAcross() == end.getAcross()) {
            return true;
        } else if (start.getDown() == end.getDown()) {
            return false;
        }
        return false;
    }
}