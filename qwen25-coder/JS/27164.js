// Select the target div by its ID\nvar container = document.getElementById("topics");\n\n// Create the new section's HTML as a string\nvar newSectionHTML = '<div id="mysection">Your content here</div>';\n\n// Insert the new HTML into the selected div\ncontainer.innerHTML += newSectionHTML;