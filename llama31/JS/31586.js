var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");\nxmlDoc.async = false;\nxmlDoc.loadXML(xmlHttp.responseText);\n\nvar xmlRoot = xmlDoc.documentElement;\nvar postcode = xmlRoot.getElementsByTagName("Postcode")[0].childNodes[0].nodeValue;\ndocument.forms[0]["address"+addr+"_Postcode"].value = postcode.substring(0, postcode.length-1);