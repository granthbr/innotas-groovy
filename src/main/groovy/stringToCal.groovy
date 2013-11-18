import java.text.SimpleDateFormat

//Simple Gist to add days to date

//def today = "2013-11-13'T'12:32:01"
//yyyy-MM-dd'T'HH:mm:ss
//def innotasformatter = new SimpleDateFormat( "MM/dd/yyyy HH:mm:ss z" );
//innotasformatter.setTimeZone( TimeZone.getTimeZone( "PST" ) );
//2013-11-15T11:05:54
//def setDay = 3
//if (today) {
//    today = today.replaceAll("'T'", " ")
//    def monthStr = today.substring(today.indexOf("-") + 1, today.lastIndexOf("-"))
//    def month = Integer.parseInt(monthStr)
//    def yearStr = today.substring(0, today.indexOf("-"))
//    def dayStr = today.substring(today.lastIndexOf("-") + 1,today.indexOf(" "))
//    def day = Integer.parseInt(dayStr)
//    def year = Integer.parseInt(yearStr)
//    Calendar cal = new GregorianCalendar(year, month, day);
//    cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR)
//    slashDate =  cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH)   + "/" + cal.get(Calendar.YEAR)
//    def newDay = cal.get(Calendar.DAY_OF_MONTH) + setDay
//    cal.set(Calendar.DAY_OF_MONTH, newDay)
//    cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR) + today.substring(today.indexOf(" "))
//}




//import java.util.Properties;
//import java.io.InputStream;
//import com.boomi.execution.ExecutionManager;
//
//import com.boomi.execution.ExecutionUtil;
//
//logger = ExecutionUtil.getBaseLogger();
//
//def today = ExecutionManager.getCurrent().getProperty( "taskStartDate" )
//def setDay = ExecutionManager.getCurrent().getProperty( "setDay" )
//logger.info("Got to this point in the script! taskStartDate=" + today);
//logger.info("Got to this point in the script! setDay=" + setDay);
def today = "2013-11-15T11:05:54"
def updatedTaskDate
def setDay = 6

def boomiDateMasks = ["yyyyMMdd hhmmss.SSS","MM/dd/yyyy'T'HH:mm:ss"];


Date date =
def innotasformatter = new SimpleDateFormat( "MM/dd/yyyy HH:mm:ss z" );
innotasformatter.setTimeZone( TimeZone.getTimeZone( "PST" ) );

if (today) {
    today = today.replaceAll("T", " ").replaceAll("-","/")
   // logger.info("Got to this point in the script! today=" + today);
    def monthStr = today.substring(today.indexOf("/") + 1, today.lastIndexOf("/"))
   // logger.info("Got to this point in the script! monthStr=" + monthStr);
    def month = Integer.parseInt(monthStr)
  //  logger.info("Got to this point in the script! month=" + month);
    def yearStr = today.substring(0, today.indexOf("/"))
  //  logger.info("Got to this point in the script! yearStr=" + yearStr);
    def dayStr = today.substring(today.lastIndexOf("/") + 1,today.indexOf(" "))
   // logger.info("Got to this point in the script! dayStr=" + dayStr);
    def day = Integer.parseInt(dayStr)

    def year = Integer.parseInt(yearStr)
    def colonIndex = today.indexOf(":")
    def hourStr = today.substring(today.indexOf(" ")+1,today.indexOf(":"))
    def hour = Integer.parseInt(hourStr)
    colonIndexMin = colonIndex + 2

    def minStr = today.substring(colonIndex +1,colonIndexMin)
    def min  = Integer.parseInt(minStr)
    coloneIndexSec = colonIndexMin +2
    def secStr = today.substring(colonIndexMin +1,coloneIndexSec)
    def secs  = Integer.parseInt(secStr)
    //logger.info("Got to this point in the script! year=" + year);
    Calendar cal = new GregorianCalendar(year, month, day);
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss z");
    cal.set(year, month, day,)
    println sdf.format(cal.getTime())
    cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR)
 //   logger.info("Got to this point in the script! cal =" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH)   + "/" + cal.get(Calendar.YEAR));
    def newDay = cal.get(Calendar.DAY_OF_MONTH) + setDay
     //cal.setTimeZone(TimeZone.getTimeZone("PST"))


    cal.set(Calendar.DAY_OF_MONTH, newDay)


    updatedTaskDate = cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR) + today.substring(today.indexOf(" "))
   // logger.info("Got to this point in the script! updatedTaskDate=" + updatedTaskDate);
}
//ExecutionManager.getCurrent().setProperty( "innotasTaskDate", today )
//ExecutionManager.getCurrent().setProperty( "updatedTaskDate", updatedTaskDate )
//
//
//for( int i = 0; i < dataContext.getDataCount(); i++ ) {
//    InputStream is = dataContext.getStream(i);
//    Properties props = dataContext.getProperties(i);
//
//    dataContext.storeStream(is, props);
//}