// Assume you have a validator instance for your form\nvar validator = $("#yourForm").validate();\n\n// Mark the element as invalid and add an error message\nvalidator.showErrors({\n    "elementName": "Your error message here."\n});