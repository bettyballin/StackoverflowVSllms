document.addEventListener('keydown', function(event) {\n  if (event.key === 'ArrowUp' || event.key === 'ArrowDown' || event.key === 'ArrowLeft' || event.key === 'ArrowRight') {\n    event.preventDefault();\n  }\n});