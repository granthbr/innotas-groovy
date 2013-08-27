import groovy.xml.StreamingMarkupBuilder
import org.apache.commons.io.IOUtils

InputStream is = new FileInputStream("/Users/brandon/projects/innotas/JiraJsonXML/nyackZd.xml");
String xmlStr = IOUtils.toString(is);



//def newxml = new XmlSlurper().parseText( xmlStr ).with { x ->
//    [ '/ZenDesk_updateTask_response/facets', '/ZenDesk_updateTask_response/count' ].each { path ->
//        def s = path.split( '/' ).dump().inject(x)  { element, p ->
//            element."$p"
//        }?.replaceNode {}
//    }
//    x
//}


//def Node nd = new Node();

def records = new XmlSlurper().parse("/Users/brandon/projects/innotas/JiraJsonXML/nyackZd.xml")
//def visit(node, Closure c) {
//    node.childNodes().each { child ->
//        c(child)
//        if(child.name.equals("count")){
//           println child.indexOf(child.name)
//           child.remove(child.children.indexOf(child.name))
//        }
//        visit(child, c)
//    }
//}
//
//visit(records) { node ->
//    println node.name
//}
//visit(xmlStr) { node ->
//    println node.name
//}
//println XmlUtil.serialize(new StreamingMarkupBuilder().bind {
//    mkp.yield newxml
//})


def resource = new XmlSlurper().parseText(xmlStr)
    //new XmlParser().parseText(xmlStr)
resource.count[0].replaceNode() {}
resource.previous_page[0].replaceNode() {}
resource.facets[0].replaceNode() {}
resource.next_page[0].replaceNode() {}
def newResource = new StreamingMarkupBuilder().bind {
mkp.yield resource}.toString()
println newResource


//def xpathsToDelete = ['/ZenDesk_updateTask_response/count','/ZenDesk_updateTask_response/previous_page','/ZenDesk_updateTask_response/next_page','/ZenDesk_updateTask_response/previous_page','/ZenDesk_updateTask_response/facets']
//
//xpathsToDelete.each { xpath ->
//    def trimXPath = xpath.replaceFirst( "/ZenDesk_updateTask_response/", "").replace("/",".")
//    removeNodes(resource, trimXPath)
//}
//
//println XmlUtil.serialize(new StreamingMarkupBuilder().bind {
//    mkp.yield resource
//})


