function serializeFormWithDisabled($form) {\n    var serialized = $form.serializeArray();\n    // Add disabled fields to the array\n    $form.find(':disabled').each(function() {\n        serialized.push({\n            name: this.name,\n            value: $(this).val()\n        });\n    });\n    return $.param(serialized);\n}\n\n// Usage with AJAX:\n$.ajax({\n    type: 'POST',\n    url: '/your/submission/url',\n    data: serializeFormWithDisabled($('#yourFormId')),\n    success: function(response) {\n        // Handle the response\n    }\n});