window.onload = function() {\n    var inputs = document.getElementsByTagName('input');\n    for (var i = 0, l = inputs.length; i < l; i++) {\n        var input = inputs[i];\n        if (input.name && input.name == 'date') {\n            input.setAttribute('onchange', 'validateDate(this);');\n        }\n    }\n\n    // Serialize the updated DOM to HTML\n    var htmlString = document.documentElement.outerHTML;\n    console.log(htmlString);\n};\n\nfunction validateDate(input) {\n    // Do something when the content of the 'input' element with the name 'date' is changed.\n}