// In the iframe\nfunction uploadImage() {\n  // Get the input file element in the iframe\n  var inputFile = document.getElementById('inputFile');\n\n  // Access the parent page's element\n  var parentElement = parent.document.getElementById('uploadedImages');\n\n  // Add the uploaded image to the parent page's element\n  parentElement.innerHTML += '<img src="' + inputFile.files[0].name + '">';\n}