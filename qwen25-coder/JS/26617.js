var GoalID = "e13e68a8-ae18-49f1-9d2f-e052a63fac51";\nif ($.browser && $.browser.msie && window.XDomainRequest) {\n    // For IE 8 and below, may need to handle differently\n    var xdr = new XDomainRequest();\n    xdr.open("GET", "http://www.externallink.co.uk/GoalAccessed.aspx?id=" + GoalID);\n    xdr.onload = function() {\n        alert(xdr.responseText); // or process it as needed\n    };\n    xdr.onerror = function() {\n        alert('Error occurred.');\n    };\n    setTimeout(function() { xdr.send(); }, 0); // Workaround for IE timing issues\n} else {\n    // Modern browsers, Firefox, Chrome etc.\n    try {\n        $.ajax({\n            type: "GET",\n            url: "http://www.externallink.co.uk/GoalAccessed.aspx?id=" + GoalID,\n            dataType: "script"\n        });\n    } catch(err) { alert('An error occurred ' + err); }\n}