function autoResizeTextArea(textArea) {\n    textArea.style.height = 'auto';\n    textArea.style.height = textArea.scrollHeight + 'px';\n}\n\n// Call this function on page load and on print\nwindow.onload = function() {\n    var textArea = document.getElementById('yourTextAreaId');\n    autoResizeTextArea(textArea);\n};\n\n// Call this function on print\nwindow.onbeforeprint = function() {\n    var textArea = document.getElementById('yourTextAreaId');\n    autoResizeTextArea(textArea);\n};