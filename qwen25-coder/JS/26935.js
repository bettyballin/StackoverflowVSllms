$(document).ready(function() {\n    var $element = $('div'); // Select your target element\n    var classesArray = $element.attr('class').split(/\s+/); // Split classes into an array\n\n    console.log(classesArray); // Output: ["Lorem", "ipsum", "dolor_spec", "sit", "amet"]\n\n    // To search for a specific class pattern, e.g., ending with "_spec":\n    var specialClass = $.grep(classesArray, function(className) {\n        return className.match(/_spec$/);\n    });\n\n    console.log(specialClass); // Output: ["dolor_spec"]\n});