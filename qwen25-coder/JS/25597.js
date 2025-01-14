const zlib = require('zlib');\nconst express = require('express');\nconst app = express();\n\napp.get('/data', (req, res) => {\n    const largeData = generateLargeData(); // Function to generate a large JSON object\n    zlib.gzip(JSON.stringify(largeData), (err, buffer) => {\n        if (err) return res.status(500).send(err);\n        res.setHeader('Content-Encoding', 'gzip');\n        res.send(buffer);\n    });\n});\n\nfunction generateLargeData() {\n    // Generate a large JSON object here\n}\n\napp.listen(3000, () => console.log('Server running on port 3000'));