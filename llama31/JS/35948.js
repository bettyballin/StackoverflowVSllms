const div = document.getElementById('myDiv');\n\ndiv.addEventListener('mouseup', () => {\n  const selection = window.getSelection();\n  if (selection && selection.toString() !== '') {\n    // Handle selection event\n    console.log('Selection detected:', selection.toString());\n  }\n});