import java.text.SimpleDateFormat
/**
 * Created with IntelliJ IDEA.
 * User: brandon
 * Date: 4/19/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */

String string1 = "5/7/2012";
String string2 = "6/13/2013";

SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

Date date1 = sdf.parse(string1);
Date date2 = sdf.parse(string2);

date3 = Date.parse(string1)
date4 =Date.parse(string2)
//println date3.toString()
//println date4.toString()
//println date3 - date4

long diffInMilli = date1.getTime() - date2.getTime()
//println diffInMilli
//int days = (int) (diffInMilli.abs()/(1000*60*60*24))
String test = "223342,44423223"
String test2 = "3322334"

StringBuilder sb = new StringBuilder(test);
if(sb.toString().contains(test2)){
    println "true"
    //set property for skip
} else
    sb.append(",").append(test2)
println sb.toString()



def inputDouble = "40.9"
def period = inputDouble.indexOf(".")
def hours = inputDouble.substring(0,period)
def tenths = inputDouble.substring(period,inputDouble.length())
def minutesDoub = 60 * Double.parseDouble(tenths)
def minutes = minutesDoub.toInteger()
if(minutes < 10){
    minutes = minutes + "0"
}
def days =  (hours.toInteger()/24)
def dayPeriod = days.toString().substring(0,days.toString().indexOf("."))
def dayToHour = (hours.toInteger()%24)
def estimatedHours = dayPeriod +" "+ dayToHour + ":" + minutes


//println hours
//println tenths
//println minutes
//println estimatedHours








//def period = inputDouble.indexOf(".")
//def hours = inputDouble.substring(0,period-1)
//def tenths = inputDouble.substring(period,inputDouble.length())
//def minutesDoub = 60 * Double.parseDouble(tenths)
//def minutes = minutesDoub.toInteger()
//def estimatedHours = hours + ":" + minutes + ":00"



