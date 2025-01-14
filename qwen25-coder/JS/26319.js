function isAJAXSupported() {\n    var xmlHttp = null;\n\n    // Check for standard XMLHttpRequest\n    if (typeof window.XMLHttpRequest !== "undefined") {\n        xmlHttp = new window.XMLHttpRequest();\n    } else if (window.ActiveXObject) { // Fallback for old IE\n        try {\n            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP.6.0");\n        } catch (e1) {\n            try {\n                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP.3.0");\n            } catch (e2) {\n                try {\n                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");\n                } catch (e3) {}\n            }\n        }\n    }\n\n    return xmlHttp !== null;\n}