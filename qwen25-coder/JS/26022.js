// Storing content in localStorage\nfunction saveContentToCache(key, htmlContent) {\n    localStorage.setItem(key, htmlContent);\n}\n\n// Retrieving content from localStorage\nfunction getContentFromCache(key) {\n    return localStorage.getItem(key);\n}