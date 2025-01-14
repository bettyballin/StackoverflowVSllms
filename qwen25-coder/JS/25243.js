// Check if there's an active session and load sensitive data\nwindow.onload = function() {\n    // Assume checkSession returns a promise or uses a callback\n    checkSession().then(isAuthenticated => {\n        if (isAuthenticated) {\n            loadDataFromServer();\n        } else {\n            clearSensitiveData();\n        }\n    });\n};\n\nfunction loadDataFromServer() {\n    // Fetch data securely and store in sessionStorage\n    fetch('/api/get-data', {credentials: 'same-origin'})\n    .then(response => response.json())\n    .then(data => {\n        sessionStorage.setItem('sensitiveData', JSON.stringify(data));\n    });\n}\n\nfunction checkSession() {\n    return fetch('/api/check-session', {credentials: 'same-origin'})\n        .then(response => response.ok);\n}\n\nfunction clearSensitiveData() {\n    sessionStorage.removeItem('sensitiveData');\n}\n\n// On logout, clear session and sensitive data\ndocument.getElementById('logoutButton').addEventListener('click', function(event) {\n    event.preventDefault();\n    fetch('/api/logout', {credentials: 'same-origin'})\n        .then(response => response.ok)\n        .then(loggedOut => {\n            if (loggedOut) {\n                clearSensitiveData();\n                window.location.href = '/login';\n            }\n        });\n});