package edu.oregonstate.cs361.battleship;
public class Point{
    private int Across;
    private int Down;

    //default constructor
    public Point(int a, int d){
        this.Across = a;
        this.Down = d;
    }

    public int getAcross() { return this.Across; }
    public int getDown() { return this.Down; }

    public void setAcross(int x) { this.Across = x; }
    public void setDown(int y) { this.Down = y; }


    public boolean samePointCheck(Point p) {
        if (p.getAcross() == this.Across && p.getDown() == this.Down) {
            return true;
        }

        return false;
    }

    //@Override
    //public String toString(){
        //return (int )(this.x) + " " + (int )(this.y);
    //}

    //dont think this is needed for now
    /*
    @Override
    public int compareTo(Point n2){
        int X = this.Across-n2.getAcross();
        int Y = this.Down-n2.getDown();
        if(X>0) return 1;
        else if(X<0) return -1;
        else if(Y>0) return 1;
        else if(Y<0) return -1;
        else return 0;
    }*/
}
