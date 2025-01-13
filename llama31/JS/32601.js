const controller = new AbortController();\nconst signal = controller.signal;\n\n// Use the signal with fetch\nfetch('/api/data', { signal });\n\n// Use the signal with XMLHttpRequest\nconst xhr = new XMLHttpRequest();\nxhr.open('GET', '/api/data');\nxhr.signal = signal;\n\n// Cancel the request\ncontroller.abort();