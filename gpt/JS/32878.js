document.body.addEventListener('click', function(event) {\n    // Check if the clicked element is not a link\n    if (event.target.tagName !== 'A') {\n        // Your JavaScript code here\n        console.log('A non-link element was clicked!');\n    }\n});