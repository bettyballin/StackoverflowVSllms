function handleError(result) {\n    if (!result || !result.success) {\n        alert('Error: ' + result.message);\n    }\n}\n\n// Example usage in an AJAX call\n$.ajax({\n    type: "POST",\n    url: "YourAjaxHandler.aspx/Method",\n    data: JSON.stringify({ param1: value1, param2: value2 }),\n    contentType: "application/json; charset=utf-8",\n    dataType: "json",\n    success: function (response) {\n        if (!response.success) {\n            handleError(response);\n        } else {\n            // Handle successful response\n        }\n    },\n    error: function () {\n        alert('An unexpected error occurred.');\n    }\n});