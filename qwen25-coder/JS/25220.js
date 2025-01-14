function submitUserInfo() {\n    var username = document.userForm.username.value;\n    var firstname = document.userForm.firstname.value;\n    var lastname = document.userForm.lastname.value;\n\n    var url = "edit_user.php?cmd=submitinfo&username=" + encodeURIComponent(username) +\n              "&firstname=" + encodeURIComponent(firstname) +\n              "&lastname=" + encodeURIComponent(lastname);\n\n    var xmlHttp = GetXmlHttpObject();\n    if (xmlHttp) {\n        xmlHttp.onreadystatechange = function() {\n            if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {\n                if (xmlHttp.responseText === 'true') {\n                    alert('Update successful!');\n                    // You can call updateByUser(username); here if needed.\n                } else {\n                    alert('Update failed.');\n                }\n            }\n        };\n        xmlHttp.open("GET", url, true);\n        xmlHttp.send(null);\n    } else {\n        alert('Your browser does not support XMLHTTP objects');\n    }\n}\n\nfunction GetXmlHttpObject() { // Ensure this function is defined\n    var xmlHttp=null;\n    try {\n        // Firefox, Opera 8.0+, Safari\n        xmlHttp = new XMLHttpRequest();\n    } catch (e) {\n        // Internet Explorer\n        try {\n            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");\n        } catch (e) {\n            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");\n        }\n    }\n    return xmlHttp;\n}