// Example client-side validation using JavaScript\nfunction validateForm() {\n  const username = document.getElementById('username').value;\n  if (username.length < 3) {\n    alert('Username must be at least 3 characters long');\n    return false;\n  }\n  // More validation logic here...\n  return true;\n}