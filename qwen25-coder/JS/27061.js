fetch('your-url-here')\n    .then(response => response.text())\n    .then(html => {\n        // Create a temporary container to parse the HTML\n        const tempDiv = document.createElement('div');\n        tempDiv.innerHTML = html;\n\n        // Extract the desired element from the fetched HTML\n        const targetElement = tempDiv.querySelector('#your-element-id');\n\n        if (targetElement) {\n            // Insert the extracted element into the current page\n            document.body.appendChild(targetElement);\n        }\n    })\n    .catch(error => console.error('Error fetching the data:', error));