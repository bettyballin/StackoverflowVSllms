const express = require('express');\nconst app = express();\nconst port = 3000;\n\n// Mock database for example purposes\nconst images = [\n    { id: 1, url: 'image1.jpg', tags: ['New York', 'Winter'] },\n    { id: 2, url: 'image2.jpg', tags: ['New York', 'Summer'] },\n    { id: 3, url: 'image3.jpg', tags: ['Winter', 'Nature'] },\n    // Add more images as needed\n];\n\n// Helper function to filter images by tags and return a random one\nfunction getRandomImageByTags(tags) {\n    const filteredImages = images.filter(image => \n        tags.every(tag => image.tags.includes(tag))\n    );\n\n    if (filteredImages.length === 0) {\n        return null;\n    }\n\n    const randomIndex = Math.floor(Math.random() * filteredImages.length);\n    return filteredImages[randomIndex];\n}\n\napp.get('/images/random', (req, res) => {\n    const tags = req.query.tags ? req.query.tags.split(',') : [];\n    \n    if (tags.length === 0) {\n        return res.status(400).json({ error: 'Tags parameter is required' });\n    }\n\n    const randomImage = getRandomImageByTags(tags);\n\n    if (!randomImage) {\n        return res.status(404).json({ error: 'No images found with the specified tags' });\n    }\n\n    res.json(randomImage);\n});\n\napp.listen(port, () => {\n    console.log(`Server is running on http://localhost:${port}`);\n});