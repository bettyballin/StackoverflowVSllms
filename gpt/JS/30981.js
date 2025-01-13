const express = require('express');\nconst app = express();\nconst cors = require('cors');\n\n// Use the CORS middleware\napp.use(cors());\n\napp.post('/your-endpoint', (req, res) => {\n  // Handle your request here\n  res.send('Response from the server');\n});\n\napp.listen(3000, () => {\n  console.log('Server running on port 3000');\n});