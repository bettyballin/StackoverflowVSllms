$(document).ready(function() {\n    var id = 'cbx';\n    var idPrefix = 'Arrow';\n    var html = '<img .../>';\n\n    // query parent row\n    var rowq = $('#' + id);\n    if (rowq.length < 1) {\n        rowq = $('.' + id);\n        VersionHeader = true;\n    }\n    if (rowq[0]) {\n\n        rowq.addClass('ArrowHeader');\n        // set to 0 for header\n        var index = 0;\n\n        var row = rowq.parents('.g')[0].insertRow(index);\n        // assign id for new row\n        row.id = idPrefix + id;\n        // assign classes for style and tree\n        row.className = 'srcrow' + id;\n\n        // Get the number of columns in the previous row\n        var numCols = rowq[0].cells.length;\n\n        // Insert a new cell at the desired column index\n        var cell = row.insertCell(numCols - 1); // insert at the second last column\n\n        // assign html result\n        cell.innerHTML = html;\n        // set colspan\n        cell.colSpan = 1;\n    }\n});