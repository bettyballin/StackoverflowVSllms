document.getElementById('form1').addEventListener('submit', function(event) {\n  event.preventDefault();\n  // Handle form1 submission\n  console.log('Form 1 submitted');\n});\n\ndocument.getElementById('form2').addEventListener('submit', function(event) {\n  event.preventDefault();\n  // Handle form2 submission\n  console.log('Form 2 submitted');\n});