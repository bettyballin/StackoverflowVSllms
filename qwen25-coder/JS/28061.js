// Assuming you have an AJAX submit handler for your form\n$("#yourFormId").submit(function(event) {\n    event.preventDefault(); // Prevent default form submission\n    var formData = $(this).serialize();\n    \n    $.ajax({\n        type: "POST",\n        url: this.action,\n        data: formData,\n        success: function(response) {\n            // Handle the response from the server here if needed\n            \n            // Close the Simplemodal after successful AJAX call\n            $.modal.close();\n        },\n        error: function(xhr, status, error) {\n            console.error("Error submitting form:", error);\n        }\n    });\n});