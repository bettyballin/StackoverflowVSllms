// Clear out all of the existing items\nvar selectElement = document.getElementById("ddlPersonnel");\nwhile (selectElement.options.length > 0) {\n    selectElement.remove(0);\n}\n\n// Add the "Select Personnel" option\nvar firstOpt = document.createElement('OPTION');\nfirstOpt.value = "";\nfirstOpt.text = "Select Personnel"; // Use 'text' instead of 'innerText'\n\nif (selectElement.add) { // Check if the add method is available, works in IE8 and below\n    selectElement.add(firstOpt);\n} else {\n    selectElement.appendChild(firstOpt); // Fallback for modern browsers\n}