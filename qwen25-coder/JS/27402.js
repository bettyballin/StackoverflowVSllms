function submitAllForms() {\n    var allFormData = {};\n    document.forms.each(function(form) {\n        // Serialize each form into an object and merge it with the main data object\n        Object.extend(allFormData, Form.serializeElements(form.getElementsByTagName('input'), true));\n        Object.extend(allFormData, Form.serializeElements(form.getElementsByTagName('textarea'), true));\n        Object.extend(allFormData, Form.serializeElements(form.getElementsByTagName('select'), true));\n    });\n\n    // Now use Prototype's Ajax.Request to send all the data at once\n    new Ajax.Request('/submit', {\n        method: 'post',\n        parameters: allFormData,\n        onSuccess: function(response) {\n            console.log('All forms submitted successfully');\n        },\n        onFailure: function() {\n            console.error('Failed to submit some or all of the forms');\n        }\n    });\n}\n\n// Attach this function to your master button's click event\ndocument.observe("dom:loaded", function() {\n    $('masterSubmitButton').observe('click', submitAllForms);\n});