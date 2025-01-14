// template.js\ndocument.addEventListener('DOMContentLoaded', function() {\n    // Define your common header and footer HTML here\n    const headerHTML = `\n        <header>\n            <h1>Common Header</h1>\n            <nav>\n                <!-- Navigation links go here -->\n            </nav>\n        </header>\n    `;\n\n    const footerHTML = `\n        <footer>\n            <p>&copy; 2023 Department Name. All rights reserved.</p>\n        </footer>\n    `;\n\n    // Insert the common header and footer into their respective divs\n    document.getElementById('header').innerHTML = headerHTML;\n    document.getElementById('footer').innerHTML = footerHTML;\n});