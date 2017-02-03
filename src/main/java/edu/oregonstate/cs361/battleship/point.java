
public class point implements Comparable<point>{
    public double x, y;

    public point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double X() {
        return this.x;
    }
    public double Y(){
        return this.y;
    }
    //public void setpointx(double x){
     //   this.x = x;
    //}
    //public void setpointy(double y){
    //    this.y=y;
   // }
    @Override
    public String toString(){
        return (int )(this.x) + " " + (int )(this.y);
    }

    @Override
    public int compareTo(point n2){
        double X = this.x-n2.X();
        double Y = this.y-n2.Y();
        if(X>0) return 1;
        else if(X<0) return -1;
        else if(Y>0) return 1;
        else if(Y<0) return -1;
        else return 0;
    }
}
