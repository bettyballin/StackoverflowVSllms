function setOutput(){\n    if(httpObject.readyState == 4){\n        document.getElementById('outputLabel').textContent = httpObject.responseText;\n    }\n}\n\n// Change the HTML element from textbox to label like this:\n//\n// Instead of <input type="text" id="outputText" />\n// Use: <label id="outputLabel"></label>