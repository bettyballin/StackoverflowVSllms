$(document).ready(function() {\n    // Event handler for navigation links\n    $('.nav-link').click(function(e) {\n        e.preventDefault(); // Prevent the default link behavior\n\n        // Get the query from the link's data attribute or href attribute\n        var query = $(this).data('query') || $(this).attr('href');\n\n        // Make the AJAX request\n        $.ajax({\n            url: 'fetch_records.php', // Your PHP file that processes the query\n            type: 'GET',\n            data: { query: query },\n            success: function(response) {\n                // Update the records layer with the new data\n                $('#records-layer').html(response);\n            },\n            error: function(xhr, status, error) {\n                console.error('AJAX Error: ' + status + error);\n            }\n        });\n    });\n\n    // Event handler for database records\n    $(document).on('click', '.record', function(e) {\n        e.preventDefault(); // Prevent any default behavior\n\n        // Get the data-id or any identifier for the record\n        var recordId = $(this).data('id');\n\n        // Make the AJAX request to fetch results for the selected record\n        $.ajax({\n            url: 'fetch_results.php', // Your PHP file that fetches results\n            type: 'GET',\n            data: { id: recordId },\n            success: function(response) {\n                // Update the results layer with the new data\n                $('#results-layer').html(response);\n            },\n            error: function(xhr, status, error) {\n                console.error('AJAX Error: ' + status + error);\n            }\n        });\n    });\n});