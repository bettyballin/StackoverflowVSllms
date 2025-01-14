<script>\nfunction getXMLHTTP() { //function to return the xml http object\n    var xmlhttp=false;  \n    try{xmlhttp=new XMLHttpRequest();}\n    catch(e)    {\n        try{ xmlhttp= new ActiveXObject("Microsoft.XMLHTTP"); }\n        catch(e){ \n            try{\n                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");\n            }catch(e1){\n                xmlhttp=false;\n            }\n        }\n    }\n    return xmlhttp;\n}\n\nfunction getCity(strURL) {          \n    var req = getXMLHTTP();         \n    if (req) {              \n        req.onreadystatechange = function() {\n            if (req.readyState == 4 && req.status == 200) {\n                document.getElementById('citydiv').innerHTML=req.responseText; \n            } else if (req.readyState == 4 && req.status != 200) {\n                alert("There was a problem while using XMLHTTP:\n" + req.statusText);\n            }\n        };           \n        req.open("GET", strURL, true);\n        req.send(null);\n    }\n}\n</script>