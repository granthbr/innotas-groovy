/*
ZenDesk delivers the data in nested json with duplicate field names. When attempting to
generate the XML for delivery to Boomi the data is delivered in a serialized manner once the internal
JSON Array is sent. Had to change the key name to a unique value so that Innotas mapping works correctly
in Boomi
 */

import net.sf.json.groovy.JsonSlurper
import org.apache.commons.io.IOUtils
import org.json.JSONObject
import org.json.XML

InputStream is = new FileInputStream("/Users/brandon/projects/innotas/jsonXml/innotas-groovy/nyackzd.json");
String jsonStr = IOUtils.toString(is);
//jsonStr = jsonStr.replaceAll("\"null\"","\" \"").replaceAll("\\s{2}"," ")

def jsonObj = new JsonSlurper().parseText(jsonStr)
def xmlStr = ""
def params = jsonObj.results.custom_fields
//Get params size and iterate TODO
pSize = params.size() -1
//           Created By Active? WorkEffort Inn PName Capital ComplDate Dur  InnTaskID ManSched Milestone Critical
def custom = [22937097,22929932,22939938,22420081,22924183,22931101,22941093,22326693,22924203,22931121,22924213]
def customSwitch(key, value){
    def result
    switch (key){
        case 22937097:
            result = 'createBy -- ' + value
            //ExecutionManager.getCurrent().setProperty( "createBy", value )
            break
        case 22929932:
            result = 'active'
           // ExecutionManager.getCurrent().setProperty( "active", value )
            break
        case 22939938:
            value = containNull(value)
            result = value

           // ExecutionManager.getCurrent().setProperty( "workEffort", value )
            break
        case 22420081:
            result ="innoProjName"
           // ExecutionManager.getCurrent().setProperty( "innoProjName", value )
            break
        case 22924183:
            result = "capital"
           // ExecutionManager.getCurrent().setProperty( "capital", value )
            break
        case 22931101:
            result = "complDate"
           // ExecutionManager.getCurrent().setProperty( "complDate", value )
            break
        case 22941093:
            result = 'duration'
          //  ExecutionManager.getCurrent().setProperty( "duration", value )
            break
        case 22326693:
            result = "innotasId"
          //  ExecutionManager.getCurrent().setProperty( "innotasId", value )
            break
        case 22924203:
            result = "manuallySched"
           // ExecutionManager.getCurrent().setProperty( "manuallySched", value )
            break
        case 22931121:
            result = "mileStone"
          //  ExecutionManager.getCurrent().setProperty( "mileStone", value )
            break
        case 22924213:
            result = "critical"
           // ExecutionManager.getCurrent().setProperty( "critical", value )
            break
        default:
            result = "default"

            break

    }
    result
}

for(int i = 0; i < pSize;i++){
    params[i].each{
        def temp = it.id
        def String nulVal;
        //catch for null value set inside json
        def val = it.optString("value")

        if(val.equals("null")){
            it.put("value","<null>")
            val = it.value
        }
        def tmp = customSwitch(it.id, it.value)
        println tmp
    }
}

def containNull(String value) {
    if (value.contains("null"))
        value = " "
    else{
        value
    }
    return value
}
//for(int i = 0; i < pSize;i++){
//    params[i].each{
//        def key = it.id
//        def val;

//        it.remove("id")
//        it.remove("value")
//
//
//        if(!(val.equals("null"))){
//            it.put("value",val)
//        }else
//            it.put("value","")
//        it.put("id_"+key, key)
//    }
//}


//def fieldParams = jsonObj.results.fields
//def fieldSize = fieldParams.size()
//println fieldSize
//jsonObj.results.remove(jsonObj.results.fields)
//jsonObj.results.remove(fieldParams[2])
//jsonObj.results.remove(fieldParams[3])
//jsonObj.results.remove(fieldParams[1])
////fieldParams[0].each{
////    def key = it.id
////    def val = it.value
////    it.remove("id")
////    it.remove("value")
//////    println it
////}

jsonStr = jsonObj.toString()

if( jsonStr!=null && jsonStr!="" ) {
    JSONObject jsonObj2 = new JSONObject( jsonStr )
    xmlStr = XML.toString( jsonObj2 )
}


//pSize = params.size() -1
//
//for(int i = 0; i < pSize;i++){
//    params[i].each{
//        def key = it.id
//        def val;
//        try{
//            val = it.value
//        }
//        catch(net.sf.json.JSONException e){
//            val = "null"
//        }
//        it.remove("id")
//        it.remove("value")
//
//
//        if(!(val.equals("null"))){
//            it.put("value",val)
//        }else
//            it.put("value","")
//        it.put("id_"+key, key)
//    }
//}

