// Function to check session validity\nfunction checkSession() {\n    fetch('/api/check-session', { method: 'GET' })\n        .then(response => response.json())\n        .then(data => {\n            if (!data.isValid) {\n                handleLogout();\n            }\n        })\n        .catch(error => console.error('Error checking session:', error));\n}\n\n// Function to handle logout\nfunction handleLogout() {\n    // Redirect to logout page or show a message\n    window.location.href = '/logout';\n    // Alternatively, you can display a modal with a message\n    // showModal('You have been logged out due to inactivity.');\n}\n\n// Set interval to check session every minute\nsetInterval(checkSession, 60000);\n\n// Handle global logout request (e.g., when user signs out from one tab)\nwindow.addEventListener('storage', function(event) {\n    if (event.key === 'logout') {\n        handleLogout();\n    }\n});\n\n// When logging out, set an item in localStorage to notify other tabs\nfunction performLogout() {\n    fetch('/api/logout', { method: 'POST' })\n        .then(() => {\n            localStorage.setItem('logout', 'true');\n            setTimeout(() => window.location.href = '/logout', 100); // Redirect after a short delay\n        });\n}