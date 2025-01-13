// Get all select elements\nconst selects = document.querySelectorAll('select');\n\n// Add an event listener to the form submission\ndocument.addEventListener('submit', (e) => {\n  // Prevent default form submission\n  e.preventDefault();\n\n  // Create a new FormData object\n  const formData = new FormData();\n\n  // Iterate over the select elements\n  selects.forEach((select) => {\n    // Get the selected value\n    const value = select.value;\n\n    // Check if the value is not the default value (-1)\n    if (value !== '-1') {\n      // Append the selected value to the FormData object\n      formData.append(select.name, value);\n    }\n  });\n\n  // Submit the filtered form data\n  fetch('/your-form-endpoint', {\n    method: 'POST',\n    body: formData,\n  })\n  .then((response) => response.json())\n  .then((data) => console.log(data))\n  .catch((error) => console.error(error));\n});