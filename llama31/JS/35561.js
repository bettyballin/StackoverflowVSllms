function Validate() {\n    var radioButtons = document.querySelectorAll('[id^="radioButtonAnswer"]');\n    radioButtons.forEach(function(button) {\n        console.log(button.id);\n    });\n    return false;\n}