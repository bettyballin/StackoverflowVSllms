// Get the repeater element\nvar repeater = document.getElementById('myRepeater');\n\n// Create a new row HTML string\nvar newRowHtml = '<tr><td>Column 1</td><td>Column 2</td></tr>';\n\n// Insert the new row at the end of the repeater\nrepeater.insertAdjacentHTML('beforeend', newRowHtml);