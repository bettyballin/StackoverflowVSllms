// Check if the content received is the authentication required message\nif (document.body.textContent.trim() === '{"authentication":"required"}') {\n    // Execute your existing JavaScript to show a popup and redirect.\n    alert("Your session has expired. Please log in again.");\n    window.location.href = "/login"; // Adjust the URL as necessary\n}