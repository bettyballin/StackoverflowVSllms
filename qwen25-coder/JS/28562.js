// Get the select element by its ID\nvar selectElement = document.getElementById('gender');\n\n// Get the index of the selected option\nvar selectedIndex = selectElement.selectedIndex;\n\n// Get the text of the selected option\nvar selectedText = selectElement.options[selectedIndex].text;\n\nconsole.log(selectedText); // Outputs: "ALL" or "Male Only" or "Female Only"