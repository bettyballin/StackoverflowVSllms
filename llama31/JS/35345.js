function fetchcomplete(layer) {\n    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n        console.log(xmlhttp.responseText);\n        layer.innerHTML = xmlhttp.responseText;\n    } else {\n        console.error(xmlhttp.statusText);\n    }\n}