// Assuming 'responseText' is your AJAX response in JSON format as a string\ntry {\n    var userData = JSON.parse(responseText);\n    // Now YOU can safely use userData to update your page\n} catch (e) {\n    console.error("Invalid JSON:", e);\n}