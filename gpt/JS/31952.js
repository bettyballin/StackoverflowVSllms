// Server-side using Node.js and Express\nconst express = require('express');\nconst app = express();\n\napp.get('/get-time', (req, res) => {\n  res.json({ serverTime: Date.now() });\n});\n\napp.listen(3000, () => {\n  console.log('Server time endpoint running on port 3000');\n});