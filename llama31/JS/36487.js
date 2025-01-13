// Assume 'countryList' is an array of country objects\n\n// Create a search input and attach an event listener\nconst searchInput = document.getElementById('search-input');\nsearchInput.addEventListener('input', (e) => {\n  const searchQuery = e.target.value.toLowerCase();\n  const filteredCountries = countryList.filter((country) => {\n    return country.name.toLowerCase().includes(searchQuery);\n  });\n  // Update the select options with the filtered countries\n  const selectElement = document.getElementById('country-select');\n  selectElement.innerHTML = '';\n  filteredCountries.forEach((country) => {\n    const optionElement = document.createElement('option');\n    optionElement.value = country.code;\n    optionElement.textContent = country.name;\n    selectElement.appendChild(optionElement);\n  });\n});