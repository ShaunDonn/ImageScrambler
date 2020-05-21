package actualIAMaybe;
public class rowerClass extends personClass {
    private String twoktime;
    private String sixktime;
    private int oneminutewatts;
    private int peakpowerwatts;
    private int wingspan;
    private int weight;
    private int height;
    private String racingcategory;
    private String coach;
    private char gender;
    
    rowerClass (){
        super();
        twoktime = "";
        sixktime = "";
        oneminutewatts = 0;
        peakpowerwatts = 0;
        wingspan = 0;
        weight = 0;
        height = 0;
        racingcategory = ""; 
        coach = "";
        gender = 'F';
    }
    public void setStats (String twoktime, String sixktime, int oneminutewatts, int peakpowerwatts, int wingspan, int weight, int height, String racingcategory, String coach, char gender){
        this.twoktime = twoktime;
        this.sixktime = sixktime;
        this.oneminutewatts = oneminutewatts;
        this.peakpowerwatts = peakpowerwatts;
        this.wingspan = wingspan;
        this.weight = weight;
        this.height = height;
        this.racingcategory = racingcategory;
        this.coach = coach;
        this.gender = gender;
    }
}
