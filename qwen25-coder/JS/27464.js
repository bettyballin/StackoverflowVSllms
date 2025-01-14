// Node.js example for RESTful API with Express and MySQL interaction\nconst express = require('express');\nconst mysql = require('mysql');\nconst app = express();\n\napp.use(express.json());\n\nconst db = mysql.createConnection({\n    host: 'localhost',\n    user: 'root',\n    password: '',\n    database: 'social_network'\n});\n\ndb.connect(err => {\n    if (err) throw err;\n});\n\n// Add a new user\napp.post('/users', (req, res) => {\n    const { name } = req.body;\n    const sql = "INSERT INTO users SET ?";\n    db.query(sql, { name }, (error, results) => {\n        error ? res.status(500).send(error) : res.json({ id: results.insertId, ...req.body });\n    });\n});\n\n// Establish a friendship between two users\napp.post('/friends', (req, res) => {\n    const { user_id, friend_id } = req.body;\n    const sql = "INSERT INTO friendships SET ?";\n    db.query(sql, { user_id, friend_id }, (error, result) => {\n        error ? res.status(500).send(error) : res.send('Friendship created');\n    });\n});\n\napp.listen(8000, () => console.log("Server running on port 8000"));