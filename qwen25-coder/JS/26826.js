// Add the following in your home page JavaScript\nif ('serviceWorker' in navigator) {\n    window.addEventListener('load', () => {\n        navigator.serviceWorker.register('/sw.js')\n            .then(registration => console.log('Service Worker registered with scope:', registration.scope))\n            .catch(error => console.error('Service Worker registration failed:', error));\n    });\n}