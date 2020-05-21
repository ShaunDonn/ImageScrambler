package actualIAMaybe;
public class personClass {
    protected String IDnum;
    protected String password;
    
    personClass(){
        IDnum = "N/A";
        password = "";
    }
    public void setPassword(String psswd){
        password = psswd;
    }
    public String getPassword (){
        return password;
    }
    public void setIDnum(String idnum){
        IDnum = idnum; 
    }
}
