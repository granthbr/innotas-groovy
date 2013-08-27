/*
ZenDesk delivers the data in nested json with duplicate field names. When attempting to
generate the XML for delivery to Boomi the data is delivered in a serialized manner once the internal
JSON Array is sent. Had to change the key name to a unique value so that Innotas mapping works correctly
in Boomi
 */

import net.sf.json.groovy.JsonSlurper
import org.apache.commons.io.IOUtils

InputStream is = new FileInputStream("/Users/brandon/projects/innotas/jsonXml/innotas-groovy/nyackzd.json");
String jsonStr = IOUtils.toString(is);
jsonStr = jsonStr.replaceAll("null","\"null\"")


def jsonObj = new JsonSlurper().parseText(jsonStr)



def params = jsonObj.results.custom_fields
//params.each{
//    def tmp =  it.id
//    tmp.each{item ->
//        println item
//    }
//    println tmp
//
//}

println params.size()
def inside = params[0]
def doubInside = inside[0]
def tmpInside =  doubInside
def key = doubInside.id
def value = doubInside.value
println key
println value
doubInside.remove("id")
doubInside.remove("value")
doubInside.put(key, key)
if(!(value.equals("null"))){
doubInside.put("value",value)
}else
    doubInside.put("value","")
println doubInside

println trip.put("1234",0)
println params[0].value


