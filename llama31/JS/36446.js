function select(item, type) {\n    // ...\n\n    var xmlHttp = new XMLHttpRequest();\n\n    // ...\n\n    xmlHttp.open("GET", url, true);\n    xmlHttp.send(null);\n    xmlHttp.onreadystatechange = catchResponse;\n\n    return false;\n}\n\nfunction catchResponse() {\n    if (this.readyState == 4) {\n        document.getElementById("page").innerHTML = this.responseText;\n    }\n\n    return false;\n}