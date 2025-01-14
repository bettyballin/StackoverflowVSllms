function getSearchItem() {\n    var gs = document.forms.mainform.resultsfield;\n    var searchword = document.forms.mainform.searchform.value;\n\n    if (searchword.length >= 3) {\n        setWaitCursor();\n        clearResults();\n        var uri = "http://site.com/ajax_handler.php?s=" + encodeURIComponent(searchword);\n        console.log(uri);\n\n        xmlhttp.open("GET", uri, true);\n        xmlhttp.onreadystatechange = function() {\n            if (xmlhttp.readyState == 4) {\n                if (xmlhttp.status == 200) { // Check HTTP status\n                    processResults(xmlhttp.responseText);\n                    removeWaitCursor();\n                } else {\n                    console.error('Request failed with status:', xmlhttp.status);\n                }\n            } else {\n                console.log(xmlhttp.readyState);\n            }\n        };\n        xmlhttp.onerror = function() {\n            console.error('Network error');\n        };\n        xmlhttp.send(null);\n    } else {\n        alert("please add at least 3 characters.");\n    }    \n}