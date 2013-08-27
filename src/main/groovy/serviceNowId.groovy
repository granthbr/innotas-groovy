import org.apache.commons.io.IOUtils

InputStream is = new FileInputStream("/Users/brandon/projects/innotas/JiraJsonXML/nyackZd.xml");
String xml = IOUtils.toString(is);


def serviceNowId = new XmlParser().parseText(xml)

String [] tmp;

serviceNowId.entityId.each{
    tmp =  it.text()
}
println serviceNowId.entityId.text()

