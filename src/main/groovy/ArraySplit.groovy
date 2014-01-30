//import com.boomi.execution.ExecutionManager;
//import com.boomi.execution.ExecutionUtil;

def vtierIdArray = ""
def splitArr = vtierIdArray.split(",")
def size = splitArr.size()

     if(vtierIdArray.isEmpty()){
         println "empty"
     }


//logger.info("Got to this point in the script! xmlItem=" + xmlItem);
if(vtierIdArray && size > 0 ){
    if(size == 1){
        vtierId = splitArr[0]
        vtierIdArray = replaceArray(splitArr)
    }else if(size == 2){
        vtierId = splitArr[0] ;
        vtierId2 = splitArr[1];
        vtierIdArray = replaceArray(splitArr)
    }else if(size > 2){
        vtierId = splitArr[0] ;
        vtierId2 = splitArr[1];
        vtierIdArray = replaceArray(splitArr)
    }

}


def replaceArray(String [] splitArr){
    String [] replArray;
    if(splitArr.size() <=1){
          replArray = new String[1]
        replArray[0] = "empty"
        return replArray
    }else if(splitArr.size() == 2){
        replArray = new String[1]
        replArray[0] = "empty"
        return replArray
    }else if(splitArr.size()>2){
       def replSize = splitArr.size()-2
       replArray = new String[replSize]
         int j =2
        for( int i = 0; i < replSize; i++) {
            replArray[i] = splitArr[j];
            j++;
        }
        return replArray
    }
}


def commaString(String [] vtierIdArray){
    StringBuilder sb = new StringBuilder();
for (String n : vtierIdArray) {
    if (sb.length() > 0) sb.append(',');
    sb.append("'").append(n).append("'");
}
return sb.toString();
}
commaString(vtierIdArray)


//if(vtierIdArray){
//    if(size >= 2 ){
//        vtierId =  splitArr[0]
////        println vtierId
//        vtierId2 = splitArr[1]
////        println vtierId2
//        def newArr
//        if(size == 2){
//            vtierIdArray = ""
//        }else if(size > 2) {
//        def count = 0
//        for(String s:splitArr){
//            if(count >=2 ){
//                newArr = s + ","
//            }
//            count++
//        }
//        }
//        vtierIdArray = newArr
//
//    }else{
//        vtierId =  splitArr[0]
//        //println vtierId + " single"
//        vtierIdArray = ""
//
//    }
//}

//ExecutionManager.getCurrent().setProperty( "vtierId", vtierId )
//ExecutionManager.getCurrent().setProperty( "vtierId2", vtierId2 )
//ExecutionManager.getCurrent().setProperty( "vtierIdArray", vtierIdArray )

