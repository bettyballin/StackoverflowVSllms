const express = require('express');\nconst bodyParser = require('body-parser');\nconst mysql = require('mysql');\n\nconst app = express();\napp.use(bodyParser.urlencoded({ extended: false }));\n\n// MySQL database connection\nconst db = mysql.createConnection({\n    host: 'your-database-host',\n    user: 'your-database-user',\n    password: 'your-database-password',\n    database: 'your-database-name'\n});\n\ndb.connect(err => {\n    if (err) throw err;\n    console.log('Database connected!');\n});\n\n// Webhook endpoint to receive SMS\napp.post('/sms', (req, res) => {\n    const from = req.body.From;\n    const body = req.body.Body;\n\n    // Save the SMS to the database\n    const query = 'INSERT INTO messages (phone, message) VALUES (?, ?)';\n    db.query(query, [from, body], (err, result) => {\n        if (err) throw err;\n        console.log('SMS saved to database');\n    });\n\n    // Respond to Twilio with a 200 OK\n    res.status(200).send('<Response></Response>');\n});\n\n// Start the server\nconst port = process.env.PORT || 3000;\napp.listen(port, () => {\n    console.log(`Server is running on port ${port}`);\n});