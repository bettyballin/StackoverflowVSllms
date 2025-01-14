document.getElementById('townshipInput').addEventListener('input', function() {\n    const query = this.value;\n    fetch(`/autocomplete?query=${encodeURIComponent(query)}&state= NJ`) // Pass the state as a parameter\n        .then(response => response.json())\n        .then(data => updateSuggestions(data));\n});\n\nfunction updateSuggestions(suggestions) {\n    const dropdown = document.getElementById('suggestionDropdown');\n    dropdown.innerHTML = suggestions.map(item => `<option>${item.name}</option>`).join('');\n}