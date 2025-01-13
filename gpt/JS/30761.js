// Controller: JavaScript/jQuery\n$(document).ready(function() {\n    $('#fetchDataButton').on('click', function() {\n        $.ajax({\n            url: 'https://example.com/api/data', // Model: Server-side endpoint\n            method: 'GET',\n            success: function(data) {\n                // View: Update the DOM with the received data\n                $('#dataContainer').html(data);\n            },\n            error: function(error) {\n                console.error('Error fetching data', error);\n            }\n        });\n    });\n});