// Assuming you have defined oParts in terms of an array or object for simplicity.\nfunction openChildWindow() {\n    var childWin = window.open('child.html', '_blank');\n    childWin.onload = function() {\n        childWin.setParts(oParts); // Pass the parts to the child window once it has loaded\n    };\n}\n\n// Prepare your data in a format that can be transferred, e.g., as a JSON string\nfunction GetParts(oRS) {\n    var parts = [];\n    if (!oRS.BOF && !oRS.EOF) {\n        do {\n            parts.push(oRS.Fields("Part").Value);\n            oRS.MoveNext();\n        } while (!oRS.EOF);\n    }\n    return parts;\n}