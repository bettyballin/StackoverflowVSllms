// Get the select element by its ID\nvar selectElement = document.getElementById('test');\n\n// Get the index of the selected option\nvar selectedIndex = selectElement.selectedIndex;\n\n// Retrieve the text of the selected option\nvar selectedText = selectElement.options[selectedIndex].text;\n\nconsole.log(selectedText); // Outputs: "Test One" or "Test Two", depending on the selectio