// Client-side JavaScript\nfetch('/resource', {\n  method: 'POST',\n  headers: {\n    'Content-Type': 'application/json',\n  },\n  body: JSON.stringify({\n    _method: 'PUT', // or 'DELETE'\n    // other data...\n  }),\n})