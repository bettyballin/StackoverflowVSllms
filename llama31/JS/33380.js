var formEnabled = true;\n\n// To disable form submission\nformEnabled = false;\n$('#yourForm').submit(function(e) {\n    if (!formEnabled) {\n        e.preventDefault();\n    }\n});\n\n// To enable form submission\nformEnabled = true;