// Assume 'data' is the response from the AJAX request\nconst template = `\n  <div>\n    <h2>${data.title}</h2>\n    <p>${data.description}</p>\n  </div>\n`;\n\n// Use the template to render the data\nconst renderedHtml = template.replace(/\${(.*?)}/g, (match, key) => data[key]);\ndocument.getElementById('container').innerHTML = renderedHtml;