const markup = '<p>description like <a href="myexample.com"></a></p>';\n\nconst parser = new DOMParser();\nconst doc = parser.parseFromString(markup, 'text/html');\n\nconst links = doc.querySelectorAll('a');\n\nlinks.forEach((link) => {\n  // Remove the link\n  link.remove();\n  // or edit the link\n  // link.href = 'new-url.com';\n  // link.textContent = 'New Link Text';\n});\n\nconst editedMarkup = doc.body.innerHTML;\nconsole.log(editedMarkup);