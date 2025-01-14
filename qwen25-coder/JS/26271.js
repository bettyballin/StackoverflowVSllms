$(document).ready(function(){\n    // ... existing tab click handlers ...\n\n    $('#yourFormId').on('submit', function(event) {\n        event.preventDefault(); // Prevent the default form submission\n\n        $.ajax({\n            type: "POST",\n            url: $(this).attr('action'), // URL where form data is being sent\n            data: $(this).serialize(), // Form data to send\n            success: function(response) {\n                loadTab(2); // Load tab 2 content after successful form submission\n\n                // Optionally, you can also display the response or a confirmation message\n                alert('Form submitted successfully!');\n            },\n            error: function(xhr, status, error) {\n                console.error("Error submitting form:", error);\n                alert('There was an error submitting your form.');\n            }\n        });\n    });\n});