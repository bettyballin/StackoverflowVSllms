const canvas = document.getElementById('yourCanvasId');\nconst rect = canvas.getBoundingClientRect();\n\ncanvas.addEventListener('mousemove', (event) => {\n  const x = event.clientX - rect.left;\n  const y = event.clientY - rect.top;\n  console.log(`Mouse location: (${x}, ${y})`);\n});