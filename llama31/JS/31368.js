document.body.addEventListener('click', function(event) {\n  if (!event.target.closest('a')) {\n    // Your JavaScript code here\n    console.log('Clicked on a non-link element');\n  }\n});