fetch('/some-endpoint', {\n    method: 'POST',\n    headers: {\n        'X-Requested-With': 'XMLHttpRequest'\n    },\n    body: JSON.stringify({ key: 'value' })\n});