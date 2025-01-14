function resetElementStyle(element) {\n    const properties = [\n        'margin', 'padding', 'line-height', 'font-size',\n        'border', 'color', 'background', 'display',\n        'width', 'height', 'position', 'top', 'right', 'bottom', 'left'\n    ];\n    properties.forEach(property => element.style[property] = '');\n}\n\n// Usage\nconst targetElement = document.querySelector('div'); // Select the div you want to reset\nresetElementStyle(targetElement);