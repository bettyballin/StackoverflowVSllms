$(document).ready(function() {\n    // Clone the original table structure but remove all child nodes (content)\n    var newTable = $('#test').clone().empty();\n\n    // Iterate through each row of the original table\n    $('#test tr').each(function() {\n        // Create a new row for the cloned table\n        var newRow = $('<tr>');\n\n        // Iterate through each cell in the current row\n        $(this).find('td').each(function() {\n            // Extract text from the cell (including text within input tags and links)\n            var cellText = $(this).text();\n\n            // Create a new cell in the cloned table with the extracted text\n            newRow.append($('<td>').text(cellText));\n        });\n\n        // Append the new row to the cloned table\n        newTable.append(newRow);\n    });\n\n    // Open a new window and display the clean HTML table\n    var win = window.open();\n    win.document.write('<html><body>');\n    win.document.write(newTable.outerHTML); // Write the cleaned table HTML\n    win.document.write('</body></html>');\n});