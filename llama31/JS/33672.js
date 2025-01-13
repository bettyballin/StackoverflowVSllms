class JSONRequestError extends Error {\n  constructor(message, xhr) {\n    super(message);\n    this.xhr = xhr;\n  }\n}\n\n// Example usage:\ntry {\n  const xhr = new XMLHttpRequest();\n  xhr.open('GET', 'https://example.com/data.json', true);\n  xhr.onload = function() {\n    if (xhr.status !== 200) {\n      throw new JSONRequestError('Failed to load data', xhr);\n    }\n    // Process the data here\n  };\n  xhr.send();\n} catch (error) {\n  if (error instanceof JSONRequestError) {\n    console.error(`JSON request error: ${error.message}`);\n    console.error(`Status code: ${error.xhr.status}`);\n  } else {\n    console.error(`Unknown error: ${error.message}`);\n  }\n}