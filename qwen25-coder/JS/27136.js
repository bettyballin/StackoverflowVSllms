document.addEventListener('DOMContentLoaded', function () {\n    const trustDiv = document.getElementById('trustInstructions');\n    \n    // Try making a request with the self-signed cert\n    fetch('https://your-server.com/check', { mode: 'no-cors' })\n        .then(() => {\n            // If successful, hide the instructions div\n            trustDiv.style.display = 'none';\n        })\n        .catch(() => {\n            // If there's an error, show the instructions div\n            trustDiv.style.display = 'block';\n        });\n});