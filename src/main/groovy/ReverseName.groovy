
uname = "Dawn Roszkowski"

def owner = "Mitchell, Jeff"
def comma = owner.indexOf(",")
//name = name.substring(comma+2,name.length()) + name.substring(0,comma)
uname = uname.replaceAll("\\s+", "").replaceAll(",","")
owner = owner.replaceAll("\\s+", "")
owner = owner.substring(comma+1, owner.length()) + owner.substring(0, comma)


println owner + " " + uname