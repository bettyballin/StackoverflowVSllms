function submitUserInfo() {\n    var url = "edit_user.php?cmd=submitinfo&username=" + encodeURIComponent(document.userForm.username.value) + "&firstname=" + encodeURIComponent(document.userForm.firstname.value) + "&lastname=" + encodeURIComponent(document.userForm.lastname.value);\n    var xmlHttp = GetXmlHttpObject();\n    if (xmlHttp.responseText == 'true') {\n        alert(url);\n        xmlHttp.open("GET", url, true);\n        xmlHttp.send(null);\n        //updateByUser(username);\n    }\n}