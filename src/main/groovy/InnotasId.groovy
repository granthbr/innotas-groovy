import org.json.JSONObject
import org.json.XML
import org.apache.commons.io.IOUtils



InputStream is = new FileInputStream("/Users/brandon/projects/innotas/JiraJsonXML/nyackZd.json");
String jsonStr = IOUtils.toString(is);
String xmlStr = ""
//ExecutionManager.getCurrent().getProperty( "json_str" )
if( jsonStr!=null && jsonStr!="" ) {
    JSONObject jsonObj = new JSONObject( jsonStr )

    xmlStr = XML.toString( jsonObj )
}

def zdInnotasIdField = "22326693"

xmlStr = "<root>" + xmlStr +"</root>"
def node = new XmlParser().parseText(xmlStr)
def returnId(node, zdInnotasIdField){
    def NodeList id = null
    def idText = ''
    nodeList = node.depthFirst()

    for(Object all:nodeList){
        for(int i = 0;i < all.value().size();i++)
            if( all.value().get(i).equals(zdInnotasIdField)){
                def parent = all.parent()
                id = parent.value()
                id.each{
                    idText = it.text()
                    if(!idText.equals(zdInnotasIdField))
                        return idText
                }
            }
    }
    return idText
}

def innotasId = returnId(node,zdInnotasIdField)
println innotasId