// Assume there is an HTML element with id 'myElement'\nvar currentElement = document.getElementById('myElement');\nvar index = $('*').index(currentElement);\n\nconsole.log(index); // This will output a unique number based on the position of #myElement in the DOM