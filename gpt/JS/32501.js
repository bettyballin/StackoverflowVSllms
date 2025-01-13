// Example of versioned routes in Express.js\n    const express = require('express');\n    const app = express();\n\n    const v1Router = express.Router();\n    v1Router.get('/resource', (req, res) => {\n        res.send('API v1 resource');\n    });\n\n    const v2Router = express.Router();\n    v2Router.get('/resource', (req, res) => {\n        res.send('API v2 resource');\n    });\n\n    app.use('/api/v1', v1Router);\n    app.use('/api/v2', v2Router);