// Set the CSRF token cookie on the server-side\ndocument.cookie = 'csrfToken=' + token + '; Secure; HttpOnly';\n\n// Read the cookie in your JavaScript code\nvar csrfToken = document.cookie.match(/csrfToken=([^;]*)/)[1];\n\n// Include the token in the AJAX request\n$.ajax({\n    type: 'POST',\n    url: '/your-endpoint',\n    data: {\n        csrfmiddlewaretoken: csrfToken,\n        // Other data...\n    }\n});