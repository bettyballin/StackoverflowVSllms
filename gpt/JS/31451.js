// Example in JavaScript\nwindow.onload = function() {\n    if (!sessionStorage.getItem('loggedIn')) {\n        window.location.href = '/login';\n    }\n};\n\n// Set sessionStorage item when logging in\nsessionStorage.setItem('loggedIn', 'true');\n\n// Remove sessionStorage item when logging out\nsessionStorage.removeItem('loggedIn');