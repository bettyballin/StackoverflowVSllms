var script = document.createElement('script');\nscript.src = 'https://api.example.com/data?callback=processData';\ndocument.body.appendChild(script);\n\nfunction processData(data) {\n  // Process data\n}