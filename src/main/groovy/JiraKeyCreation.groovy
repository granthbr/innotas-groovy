//def title = "Frank Dodd Project"
def title = "Test Big 1 huge project &"
//remove cars that are not alphanumeric
title = title.replaceAll("[^a-zA-Z\\s+]","")
//remove extra spaces
title = title.replaceAll("\\s{2}"," ").trim()
def count = countSpace(title)

println createKey(count, title)

def countSpace(String str) {
    return count = str.length() - str.replace(" ", "").length()
}

//(key.equals("")) ? str.substring(0,3): key + str.substring(0,3)

def createKey(int count, String key) {

    def keySb = new StringBuilder();
    def result = ""
    if(count == 1){
        keySb.append(key.substring(0, 2))
        count--
        key = createNewString(key)
    }
    while (count > 0) {

        if (count == 1) {
            keySb.append(key.substring(0, 1))
            count--
            key = createNewString(key)
        }
        if (count > 1) {
            keySb.append(key.substring(0, 1))
            count--
            key = createNewString(key)
        }
    }
    if (count == 0) {
        if (key.length() < 3) {
            result = key.substring(0, 1)
        } else
        if (!keySb.toString().empty) {
            result = keySb.append(key.substring(0, 1)).toString().toUpperCase()
        } else {
            result = key.substring(0, 3).toUpperCase()
        }
    }
    return result
}

def createNewString(String str) {
    def tmp = str.indexOf(" ")
    str = str.substring(str.indexOf(" ")+1, str.length())
    return str
}

