function createHttpRequest() {\n    var xmlhttp;\n    if (window.XMLHttpRequest) { // code for modern browsers\n        xmlhttp = new XMLHttpRequest();\n    } else { // code for old IE browsers\n        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");\n    }\n    return xmlhttp;\n}