document.addEventListener("DOMContentLoaded", function() {\n  // Function to get the CSRF token from the meta tag\n  function getCSRFToken() {\n    return document.querySelector('meta[name="csrf-token"]').getAttribute('content');\n  }\n\n  // Example function to handle in-place edit with the CSRF token\n  function inplaceEdit(url, data) {\n    fetch(url, {\n      method: 'POST',\n      headers: {\n        'Content-Type': 'application/json',\n        'X-CSRF-Token': getCSRFToken()\n      },\n      body: JSON.stringify(data)\n    })\n    .then(response => response.json())\n    .then(data => {\n      console.log('Success:', data);\n    })\n    .catch((error) => {\n      console.error('Error:', error);\n    });\n  }\n\n  // Example usage\n  const url = '/your_in_place_edit_url';\n  const data = { field: 'value' };\n  inplaceEdit(url, data);\n});