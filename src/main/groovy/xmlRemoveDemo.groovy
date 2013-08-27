//@Grapes(
//@Grab(group='xmlunit', module='xmlunit', version='1.3'))
//
//import org.custommonkey.xmlunit.*


import groovy.xml.StreamingMarkupBuilder

def xml = '''
<todo>
    <item priority="2">
        <title>Look into GPars</title>
    </item>
    <item priority="1">
        <title>Start developing Griffon App</title>
    </item>
    <item priority="2">
        <title>Grails 1.4 M1</title>
    </item>
    <item priority="3">
        <title>GWT Sample</title>
    </item>
</todo>
'''

def todo = new XmlSlurper().parseText(xml)

// Change node values.
def items = todo.item.findAll {
    it.@priority.toInteger() < 3
}
items.each { item ->
    item.title = "DO: " + item.title
}

// Change attribute value.
def gpars= todo.item.find {
    it.title =~ /.*GPars.*/
}
gpars.@priority = '1'

// Add extra item node.
todo.appendNode {
    item(priority: 2) {
        title 'Work on blog post'
    }
}

// Change node.
def grailsItem = todo.item.find {
    it.title.toString().contains('Grails')
}
grailsItem.replaceNode { node ->
    item(who: 'mrhaki', priority: node.@priority) {
        title 'Download Grails 1.4 M1'
    }
}
println todo

// Remove node. Index value based on result directly after parsing.
// So here we remove the item about GWT.
todo.item[3].replaceNode {}
todo.item[1].replaceNode {}
todo.item[2].replaceNode {}


// Create output.
def newTodo = new StreamingMarkupBuilder().bind {
    mkp.yield todo
}.toString()

def expected = '''
<todo>
    <item priority="1">
        <title>DO: Look into GPars</title>
    </item>
    <item priority="1">
        <title>DO: Start developing Griffon App</title>
    </item>
    <item who="mrhaki" priority="2">
        <title>Download Grails 1.4 M1</title>
    </item>
    <item priority="2">
        <title>Work on blog post</title>
    </item>
</todo>
'''
println newTodo
// Check to see expected XML equals new todo XML.
//XMLUnit.ignoreWhitespace = true
//def difference = new Diff(newTodo, expected)
//assert difference.similar()