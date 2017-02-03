package edu.oregonstate.cs361.battleship;

//Ship class for Ship.
public class Ship{
    private String user; //id which check whos ships
    private String shipName;
    private int shipLength;
    private point header;  //ship start point
    private point ender;   //ship end point

    //initialize ship
    public Ship(String shipName, String username){
        setName(shipName);//set this ship name, use name to set length
        setUser(username);
        if(shipName.equals("AircraftCarrier"))
            setLength(5);
        else if(shipName.equals("Battleship"))
            setLength(4);
        else if(shipName.equals("Cruiser"))
            setLength(3);
        else if(shipName.equals("Destoryer"))
            setLength(2);
        else if(shipName.equals("Submarine"))
            setLength(3);

        header=new point();
        ender=new point();
    }

    //function for ship user
    public String ShipUser(){return user};
    public void setUser(String username){this.user=username;}

    //function for ship name
    public String ShipName(){return shipName;}
    public void setName(String name){this.shipName=name;}

    //function for ship length
    public String ShipLength(){return shipLength;}
    public void setLength(int length){this.shipLength=length;}

    //function for ship start point
    public point shipheader(){return header;}
    public void setheader(point start){this.header=start;}

    //function for ship end point
    public point shipender(){return ender;}
    public void setender(point end){this.ender=end;}
}