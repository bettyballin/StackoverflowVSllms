// Using AbortController with fetch\nconst controller = new AbortController();\nconst signal = controller.signal;\n\nfetch('https://api.example.com/data', { signal })\n    .then(response => response.json())\n    .catch(err => {\n        if (err.name === 'AbortError') {\n            console.log('Fetch aborted');\n        } else {\n            console.error('Fetch error:', err);\n        }\n    });\n\n// To cancel the request\ncontroller.abort();