const selectElement = document.getElementById('gender');\nconst selectedLabel = selectElement.options[selectElement.selectedIndex].textContent;\n\nconsole.log(selectedLabel);