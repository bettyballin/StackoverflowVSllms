document.querySelector('input[b]').addEventListener('click', function(event) {\n    // Assuming both inputs are siblings and 'a' is immediately before 'b'\n    var aInput = event.target.previousElementSibling;\n    \n    // If 'a' doesn't have to be right before 'b' but you know the name\n    // var aInput = event.target.parentNode.querySelector('input[a]');\n    \n    if (aInput) {\n        // Manipulate aInput as needed\n        console.log(aInput.value); // Example manipulation: log value of input a\n    }\n});