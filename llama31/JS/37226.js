function stopPeriodicExecution() {\n  if (window.XMLHttpRequest) {\n    var xhr = new XMLHttpRequest();\n    xhr.abort();\n  }\n}\n\n// Call this function when the user navigates away from the div\nstopPeriodicExecution();