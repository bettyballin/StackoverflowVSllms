const express = require('express');\n   const app = express();\n   const cors = require('cors');\n\n   app.use(cors());\n\n   app.get('/', (req, res) => {\n       res.send('Hello World!');\n   });\n\n   app.listen(3000, () => {\n       console.log('Server running on http://localhost:3000');\n   });