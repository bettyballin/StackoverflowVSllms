function requestInfo(url, id, redirectPage) {\n    var temp = new Array();\n    http.open("GET", url, true);\n    http.onreadystatechange = function () {\n        if (http.readyState == 4) {\n            if (http.status == 200) {\n                var results = http.responseText;\n                if (redirectPage == "" || results != "1") {\n                    var temp = id.split("~"); // To display on multiple div \n                    var r = results.split("~"); // To display multiple data into the div \n                    if (temp.length > 1) {\n                        for (i = 0; i < temp.length; i++) { \n                            document.getElementById(temp[i]).innerHTML = r[i];\n                        }\n                    } else {\n                        document.getElementById(id).innerHTML = results;\n                    }\n\n                    // Reinitialize nicEditor for new textareas\n                    bkLib.onDomLoaded(function() {\n                        nicEditors.findEditor('netwkinfo') ? nicEditors.removeInstance('netwkinfo') : null;\n                        new nicEditor().panelInstance('netwkinfo');\n                    });\n                } else {\n                    window.location.href = redirectPage; \n                }\n            } \n        } \n    };\n    http.send(null);\n}