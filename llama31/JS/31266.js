const express = require('express');\nconst app = express();\n\napp.get('/data', (req, res) => {\n    // Simulate data retrieval\n    const data = { message: 'Hello, AJAX!' };\n    res.json(data);\n});\n\napp.listen(3000, () => console.log('Server listening on port 3000'));