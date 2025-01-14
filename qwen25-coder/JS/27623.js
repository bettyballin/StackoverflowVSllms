// Assuming you have elements with class 'editable'\n$(".editable").each(function(index, element) {\n    $(this).on('keydown', function(event) {\n        // Check if the Tab key is pressed\n        if (event.keyCode === 9) {\n            event.preventDefault(); // Stop default tabbing\n\n            var nextEditable = null;\n\n            // Find the next editable element in DOM order\n            var $currentEditableIndex = $(this).index(".editable");\n            if ($('.editable').length > $currentEditableIndex + 1) {\n                nextEditable = $('.editable').eq($currentEditableIndex + 1);\n            } else {\n                nextEditable = $('.editable').first();\n            }\n\n            // Activate JEditable for the next element\n            $(nextEditable).trigger('click');\n        }\n    });\n});\n\n// Initialize Jeditable\n$(".editable").editable("your-editable-save-handler-url", { \n    indicator: "<img src='images/indicator.gif'>",\n    submit: "Save"\n});