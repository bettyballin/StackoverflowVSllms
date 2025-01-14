document.addEventListener("DOMContentLoaded", function() {\n    var focusButton = document.getElementById('focusButtonId');\n    if (focusButton) {\n        focusButton.addEventListener('click', function() {\n            var input = document.getElementById('yourInputId');\n            if (input) {\n                input.focus();\n            }\n        });\n    }\n});