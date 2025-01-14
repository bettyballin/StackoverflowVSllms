$(document).ready(function() {\n    $('#submitButton').click(function() {\n        var formData = {\n            CustomerFormViewModel: {\n                Email: $('#CustomerFormViewModel_Email').val(),\n                // Add other properties as needed\n            }\n        };\n\n        $.ajax({\n            url: '/YourController/AddCustomer', // Update with your controller and action method path\n            type: 'POST',\n            data: JSON.stringify(formData),\n            contentType: 'application/json; charset=utf-8',\n            dataType: 'json',\n            success: function(response) {\n                // Handle the response here, e.g., show a confirmation message\n                alert('Customer added successfully!');\n            },\n            error: function(error) {\n                // Handle errors here\n                console.log(error);\n            }\n        });\n    });\n});