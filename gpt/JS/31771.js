function hideAndProcessMultiSelectBox(parm1, parm2) {\n   hideIFrame();\n   setTimeout(function() {\n       processMultiSelectBox(parm1, parm2);\n   }, 0);\n}\n\nfunction hideIFrame() {\n   var frmObj = document.getElementById("iFrameID"); // Use getElementById for better practice\n   if (frmObj) {\n       frmObj.style.visibility = "hidden";\n   }\n}\n\nfunction processMultiSelectBox(parm1, parm2) {\n   // Your logic to process the multi-select box\n}