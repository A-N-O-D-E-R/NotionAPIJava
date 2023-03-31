package anode.tool.notion.api.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Time {
    Date date;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    public Time(String timeString) throws ParseException{
        this.date = SDF.parse(timeString);
    }

    public String getTimeString(){
        return SDF.format(date);
    }

    public String toString(){
        return "Time["+getTimeString()+"]";
    }
}
