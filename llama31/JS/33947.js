// Example of a plugin listening to a mouse click event\nconst plugin = {\n  name: 'My Plugin',\n  description: 'Listens for mouse clicks',\n  run: function() {\n    document.addEventListener('click', function(event) {\n      console.log('Mouse clicked at:', event.clientX, event.clientY);\n    });\n  }\n};