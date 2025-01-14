$(document).ready(function() {\n    var $table = $('#myTable');\n    var $cells = $table.find('tr').find('td');\n    \n    // Clear existing table content and create new rows with 2 columns\n    $table.html('');\n    for (var i = 0; i < $cells.length; i += 2) {\n        var $newRow = $('<tr>');\n        \n        // Add first cell to the new row\n        $newRow.append($cells[i]);\n        \n        // Check if there is a second cell in this pair\n        if ((i + 1) < $cells.length) {\n            $newRow.append($cells[i + 1]);\n        }\n        \n        // Append the newly constructed row to the table\n        $table.append($newRow);\n    }\n});