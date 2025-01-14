const express = require('express');\nconst app = express();\napp.use(express.json());\n\napp.patch('/users/:id', (req, res) => {\n    const userId = req.params.id;\n    const updates = req.body;\n\n    // Logic to find the user and apply the updates\n    // This is a simplified example\n    User.findById(userId, (err, user) => {\n        if (err) return res.status(500).send(err);\n        if (!user) return res.status(404).send('User not found');\n\n        Object.keys(updates).forEach(key => {\n            user[key] = updates[key];\n        });\n\n        user.save((err, updatedUser) => {\n            if (err) return res.status(500).send(err);\n            res.send(updatedUser);\n        });\n    });\n});\n\napp.listen(3000, () => {\n    console.log('Server is running on port 3000');\n});