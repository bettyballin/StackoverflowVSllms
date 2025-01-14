document.addEventListener("DOMContentLoaded", (event) => {\n    // Get all links in the iframe after it loads\n    const iframe = document.querySelector('iframe');\n    iframe.onload = () => {\n        const links = iframe.contentDocument.querySelectorAll('a');\n        links.forEach(link => {\n            link.onclick = function(event) {\n                event.preventDefault(); // Prevent default action\n                yourJavaScriptFunction();\n            };\n        });\n    };\n});\n\nfunction yourJavaScriptFunction() {\n    alert("Link clicked!");\n}