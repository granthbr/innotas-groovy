// Get the date passed in from SN
def snDate = "2001-03-22"
if (snDate != null && !snDate.isEmpty() && snDate.contains('-') ) {
    def monthStr = snDate.substring(snDate.indexOf("-") + 1, snDate.lastIndexOf("-"))
    def month = Integer.parseInt(monthStr)
    def year = snDate.indexOf("-") - 1
    def day = snDate.lastIndexOf("-") + 1

    Calendar cal = new GregorianCalendar(year, month, day);
    println 'Today is  ' + cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + ' of the current year.'
    def newDay = cal.get(Calendar.DAY_OF_MONTH) + 6
    cal.set(Calendar.DAY_OF_MONTH, newDay)
}

//    println 'Today is  ' + cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + ' of the current year.'

//    println 'Today is  ' + cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + ' of the current year.'
//def getMonth(numericMonth) {
//    def alphaMonth
//    switch (numericMonth) {
//        case "01":
//            alphaMonth = "JANUARY"
//            break
//        case "02":
//            alphaMonth = "FEBRUARY"
//            break
//        case "03":
//            alphaMonth = "MARCH"
//            break
//        case "04":
//            alphaMonth = "APRIL"
//            break
//        case "05":
//            alphaMonth = "MAY"
//            break
//        case "06":
//            alphaMonth = "JUNE"
//            break
//        case "07":
//            alphaMonth = "JULY"
//            break
//        case "08":
//            alphaMonth = "AUGUST"
//            break
//        case "09":
//            alphaMonth = "SEPTEMBER"
//            break
//        case "10":
//            alphaMonth = "OCTOBER"
//            break
//        case "11":
//            alphaMonth = "NOVEMBER"
//            break
//        case "12":
//            alphaMonth = "DECEMBER"
//            break
//        default:
//            alphaMonth = 'NA'
//            break
//    }
//}


//import com.boomi.execution.ExecutionManager

def start = ExecutionManager.getCurrent().getProperty( "startDate" )
def end

if (start != null && !start.isEmpty() && start.contains('-')) {
    def monthStr = start.substring(start.indexOf("-") + 1, start.lastIndexOf("-"))
    def month = Integer.parseInt(monthStr)
    def year = start.indexOf("-") - 1
    def day = start.lastIndexOf("-") + 1

    Calendar cal = new GregorianCalendar(year, month, day);
    start =cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH)
    def newDay = cal.get(Calendar.DAY_OF_MONTH) + 6
    cal.set(Calendar.DAY_OF_MONTH, newDay)
    end = cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH)

}

ExecutionManager.getCurrent().setProperty( "startDate", start )
ExecutionManager.getCurrent().setProperty( "endDate", end )

for( int i = 0; i < dataContext.getDataCount(); i++ ) {
InputStream is = dataContext.getStream(i);
Properties props = dataContext.getProperties(i);

dataContext.storeStream(is, props);
}