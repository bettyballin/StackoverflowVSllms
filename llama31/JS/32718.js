// Add ARIA attributes to a dynamically updated element\nconst updateElement = document.getElementById('update-element');\nupdateElement.setAttribute('aria-live', 'polite');\nupdateElement.setAttribute('aria-atomic', 'true');\n\n// Update the element's content using JavaScript\nupdateElement.innerHTML = 'New content!';