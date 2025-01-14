$(document).ready(function() {\n    function fetchData() {\n        $.ajax({\n            url: '/path/to/your/json/endpoint',\n            type: 'GET',\n            dataType: 'json',\n            success: function(data) {\n                // Process and use the data to update UI\n                console.log(data);\n            },\n            error: function(xhr, status, error) {\n                console.error('Error fetching data:', error);\n            }\n        });\n    }\n\n    // Call fetchData on page load or UI interaction\n    fetchData();\n});