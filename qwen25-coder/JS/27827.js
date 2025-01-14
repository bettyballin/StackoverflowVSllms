const express = require('express');\nconst cors = require('cors');\nconst app = express();\n\n// Configure CORS to accept requests only from http://localhost\napp.use(cors({\n    origin: 'http://localhost',\n    methods: 'GET'\n}));\n\napp.get('/', (req, res) => {\n    res.json({ message: 'Hello World!' });\n});\n\napp.listen(7076, () => {\n    console.log('Server running on port 7076');\n});