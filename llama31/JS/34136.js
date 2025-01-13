const textarea = document.getElementById('myTextarea');\nconst maxLength = 1000; // set the maximum length\n\ntextarea.addEventListener('input', () => {\n  const textLength = textarea.value.length;\n  if (textLength >= maxLength) {\n    textarea.value = textarea.value.substring(0, maxLength);\n  }\n});