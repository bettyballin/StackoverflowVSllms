$(document).ready(function() {\n    $('tr.summary').each(function() {\n        var $summaryRow = $(this);\n        var $previousNormalRows = $summaryRow.prevUntil('tr.summary', 'tr.normal');\n        $summaryRow.insertBefore($previousNormalRows.first());\n    });\n});