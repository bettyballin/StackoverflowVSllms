function loadExternalCss(url) {\n  var link = document.createElement('link');\n  link.rel = 'stylesheet';\n  link.type = 'text/css';\n  link.href = url;\n  document.getElementsByTagName('head')[0].appendChild(link);\n}\n\n// Usage\nloadExternalCss('path/to/your/external.css');