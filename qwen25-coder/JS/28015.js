$(document).ready(function() {\n    $('input[type="radio"]').change(function() {\n        var selectedValue = $(this).val();\n        var url = '/Catalog/Flooring/Hardwood/Filter'; // Replace with your actual action URL\n\n        $.post(url, { filterOption: selectedValue }, function(data) {\n            // Handle the response from the server\n            console.log('Server responded:', data);\n        }).fail(function(xhr, status, error) {\n            console.error('Error:', error);\n        });\n    });\n});