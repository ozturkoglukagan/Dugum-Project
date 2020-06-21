import java.util.ArrayList;

public class Dugum {
    private int id;
    private int value;
    public ArrayList < Dugum > previousDugumler = new ArrayList < Dugum > ();
    private int point;

    //constructor
    public Dugum(int id) {
        this.id = id;

    }
    // constructor
    public void setValue(int value) {
        this.value = value;

    }
    //	this method is for calculating the points & showing how they should be done
    public void setPoint() {
        if (previousDugumler == null) {
            this.point = this.value;
        } else {
            for (Dugum d: this.previousDugumler) {
                this.point += d.getPoint();

            }
            this.point += this.value;

        }

    }
    //	this method is for using get&set principle by doing that we can keep our data private
    public int getPoint() {

        return this.point;

    }
    // this method is for checking the situation of dugums and debugging while coding
    public void dugumGoster() {
        System.out.println(this.id + " Dugum");
        System.out.println("Deger: " + this.value);
        System.out.println("Puan: " + this.point);

    }
    // arraylist constructor
    public void addPreviousDugum(Dugum d) {
        this.previousDugumler.add(d);
    }
}