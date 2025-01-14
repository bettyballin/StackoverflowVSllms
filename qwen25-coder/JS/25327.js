$(document).ready(function() {\n    // Example AJAX GET request using jQuery\n    $.ajax({\n        url: 'https://api.yourdomain.com/data',\n        type: 'GET',\n        dataType: 'json',\n        success: function(data) {\n            // Process and display data\n            console.log('Data received:', data);\n            // Example of displaying data in HTML\n            $('#dataContainer').html(JSON.stringify(data));\n        },\n        error: function(jqXHR, textStatus, errorThrown) {\n            console.error('Error fetching data:', textStatus, errorThrown);\n            // Inform user about the error\n            alert('Failed to fetch data. Please try again later.');\n        }\n    });\n});