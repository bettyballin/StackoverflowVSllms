// Assume you have a function to load new content via AJAX\nfunction loadContent(url) {\n  // Load the content via AJAX...\n}\n\n// When the user clicks on a navigation link\n// Use the History API to update the URL and title of the page\nhistory.pushState(null, "New Page Title", "/new-page-url");\n\n// Load the new content via AJAX\nloadContent("/new-page-url");