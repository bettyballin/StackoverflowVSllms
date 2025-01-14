document.addEventListener("DOMContentLoaded", function() {\n     const xmlInput = document.getElementById('xml-input');\n     const codeDisplay = document.getElementById('highlighted-code');\n\n     xmlInput.addEventListener('input', function () {\n       codeDisplay.textContent = xmlInput.value;\n       Prism.highlightElement(codeDisplay);\n     });\n   });