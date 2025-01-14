$(document).ready(function() {\n    function focusOnRow(focusedRowId) {\n        $('tr').hide(); // Hide all rows initially\n\n        var focusedRow = $('#' + focusedRowId);\n        focusedRow.show();\n\n        var rowIndex = focusedRow.index();\n        \n        if (rowIndex <= 2) { // If row X is near the top\n            $('tr:lt(' + Math.min(rowIndex + 5, $('tr').length) + ')').show();\n        } else if (rowIndex >= $('tr').length - 3) { // If row X is near the bottom\n            $('tr:gt(' + Math.max(rowIndex - 4, 0) + ')').show();\n        } else { // For rows in the middle\n            focusedRow.prevUntil(':lt(' + (rowIndex - 2) + ')').addBack().nextUntil(':gt(' + (rowIndex + 2) + ')').show();\n        }\n    }\n\n    // Assuming row X is the one with id 'focus-row'\n    focusOnRow('focus-row');\n\n    // Example: Change focus to another row, for testing purposes\n    setTimeout(function() {\n        focusOnRow('another-focus-row');\n    }, 3000);\n});