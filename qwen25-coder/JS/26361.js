$(document).ready(function() {\n    $("#SaveButton").click(function(e) {\n        var isValid = true;\n        $('.Control1').each(function() {  // Assuming all Control1 instances have class 'Control1'\n            if ($(this).find('.Control2').length == 0) {  // Similarly, 'Control2' as the class for each Control2\n                alert("Each parent control must contain at least one child control.");\n                isValid = false;\n                return false;  // Exit .each() loop early.\n            }\n        });\n        if (!isValid)\n            e.preventDefault();  // Prevent form submission.\n    });\n});