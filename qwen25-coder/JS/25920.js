var table = $("table#output");\nfor (var i in items) {\n    var thisItem = items[i];\n    (function(item) { // IIFE starts here\n        $.getJSON("myService", { "itemID": item }, function(json) {\n            var str = "<tr>";\n            str += "<td>" + item + "</td>";\n            str += "<td>" + json.someMember + "</td>";\n            str += "</tr>";\n            table.append(str);\n        });\n    })(thisItem); // IIFE ends here\n}