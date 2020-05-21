package actualIAMaybe;
public class holdStuffClass {
    public String singleDate;
    public String singleTotalTime;
    public String singleDistance;
    public String singleTime;
    public String notes;
    public String singleSplit;
    public String [][] stuff;
    
    holdStuffClass(){
        singleDate = "n/a";
        singleTotalTime = "n/a";
        singleDistance = "n/a";
        singleTime = "n/a";
        notes = "n/a";
        singleSplit = "n/a";
        stuff = null;
    }
    public void setStuff(String [][] array){
        stuff = array;
    }
}
