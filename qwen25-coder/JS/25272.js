$(document).ready(function() {\n    var currentPage = 0;\n    var pageSize = 1;\n\n    function fetchData(page) {\n        $.ajax({\n            url: 'your-endpoint-url',\n            data: { page: page, size: pageSize },\n            method: 'GET',\n            success: function(data) {\n                jsonData = data; // Assuming server returns a list of records\n                displayRecord(0); // Display the first record from fetched data\n            }\n        });\n    }\n\n    fetchData(currentPage);\n\n    $('#next-button').click(function() {\n        currentPage++;\n        fetchData(currentPage);\n    });\n\n    // Initialize display with initial fetch\n    function displayRecord(index) {\n        if (index >= jsonData.length) return;\n        var record = jsonData[index];\n        $('#record-display').html('<h2>' + record.name + '</h2><p>' + record.description + '</p>');\n    }\n});