
public class point implements Comparable<point>{
    public int x, y;

    public point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    //public void setpointx(double x){
     //   this.x = x;
    //}
    //public void setpointy(double y){
    //    this.y=y;
   // }
    public int across(){return this.x;}
    public int down(){return this.y;}


    @Override
    public int compareTo(point n2){
        int X = this.x-n2.getX();
        int Y = this.y-n2.getY();
        if(X>0) return 1;
        else if(X<0) return -1;
        else if(Y>0) return 1;
        else if(Y<0) return -1;
        else return 0;
    }
}
