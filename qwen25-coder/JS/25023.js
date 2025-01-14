const express = require('express');\nconst fs = require('fs');\nconst app = express();\nconst port = 3000;\n\n// Route to serve the HTML page\napp.get('/', (req, res) => {\n    const csvFilePath = 'data.csv'; // Path to your CSV file\n\n    fs.readFile(csvFilePath, 'utf8', (err, data) => {\n        if (err) {\n            return res.status(500).send('Error reading the CSV file.');\n        }\n\n        const htmlTable = csvToHtml(data);\n        res.send(htmlTable);\n    });\n});\n\nfunction csvToHtml(csv) {\n    const rows = csv.split('\n');\n    let table = '<html><body><table border="1"><tr>';\n\n    // Create header row\n    const headers = rows[0].split(',').map(header => `<th>${header.trim()}</th>`);\n    table += headers.join('') + '</tr>';\n\n    // Create data rows\n    for (let i = 1; i < rows.length; i++) {\n        if (!rows[i]) continue; // Skip empty lines\n        const row = rows[i].split(',').map(cell => `<td>${cell.trim()}</td>`);\n        table += `<tr>${row.join('')}</tr>`;\n    }\n\n    table += '</table></body></html>';\n    return table;\n}\n\napp.listen(port, () => {\n    console.log(`Server running at http://localhost:${port}`);\n});