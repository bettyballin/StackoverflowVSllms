$(document).ready(function() {\n    $('#yourFormId').validate({\n        // Your other options and callbacks\n\n        onfocusout: function(element) {\n            if (!element.type.match(/radio|checkbox/i) && !this.elementRule(element).remote) {\n                this.element(element);\n            }\n            // Adding a workaround for file inputs in IE\n            var isFileInput = $(element).attr('type') === 'file';\n            if (isFileInput && $.browser.msie) { // Check if the browser is IE and it's a file input\n                element.value = element.value;  // Reassigning value to prevent clearing\n            }\n        },\n\n        onkeyup: function(element, event) {\n            var excludedKeys = [16, 17, 18, 20, 35, 36, 37, 38, 39, 40, 45];\n            if (excludedKeys.indexOf(event.which) === -1 && !this.elementRule(element).remote) {\n                this.element(element);\n            }\n        },\n\n        onclick: function(element) {\n            if (element.name in this.submitted || element.type === 'checkbox' || element.type === 'radio') {\n                this.element(element);\n            }\n        }\n    });\n});