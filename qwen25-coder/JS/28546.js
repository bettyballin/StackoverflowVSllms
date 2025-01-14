// Example using Express.js\nconst express = require('express');\napp.use(express.json()); // For parsing application/json\n\napp.post('/log-click', (req, res) => {\n    const { userId, adId } = req.body;\n    \n    // Here you would insert the click data into your database\n    console.log(`User ${userId} clicked on Ad ${adId}`);\n\n    // Respond to the client that logging was successful\n    return res.status(200).json({ message: 'Click logged' });\n});\n\napp.listen(3000, () => {\n    console.log('Server running on port 3000');\n});