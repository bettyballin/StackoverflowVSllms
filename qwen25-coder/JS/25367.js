function checkSessionStatus() {\n    fetch('session_check.php')\n        .then(response => response.text())\n        .then(data => {\n            if (data === 'expired') {\n                window.location.href = 'login.php'; // Redirect to login page\n            }\n        })\n        .catch(error => console.error('Error:', error));\n}\n\n// Check session status every 5 minutes\nsetInterval(checkSessionStatus, 300000);