package special_types;

public class Time {
    private String hour;
    private String minute;
    private String seconds;

    public Time(String hour, String minute, String seconds){
        this.hour = hour;
        this.minute = minute;
        this.seconds = seconds;
    }

    public String getTime(){
        return (hour + ":" + minute + ":" + seconds);
    }

    public String[] getTimeArray(){
        return new String[]{this.hour, this.minute, this.seconds};
    }
    
}
