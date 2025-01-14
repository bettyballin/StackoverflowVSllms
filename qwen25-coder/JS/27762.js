require('dotenv').config(); // For environment variables\n\nconst express = require('express');\nconst bodyParser = require('body-parser');\nconst mongoose = require('mongoose');\n\n// Connect to MongoDB (replace with your connection string)\nmongoose.connect(process.env.DATABASE_URI, { useNewUrlParser: true, useUnifiedTopology: true });\n\n// Define a schema for storing sms data\nconst smsSchema = new mongoose.Schema({\n    from: String,\n    body: String,\n    receivedAt: { type: Date, default: Date.now }\n});\n\nconst Sms = mongoose.model('Sms', smsSchema);\n\nconst app = express();\napp.use(bodyParser.urlencoded({ extended: false }));\n\n// Endpoint to handle incoming SMS messages\napp.post('/sms-receive', (req, res) => {\n    const smsData = new Sms({\n        from: req.body.From,\n        body: req.body.Body\n    });\n\n    // Save SMS data to MongoDB\n    smsData.save().then(() => {\n        console.log('SMS saved successfully');\n        res.send('<Response></Response>'); // Responding with Twilio XML\n    }).catch(err => {\n        console.error('Error saving SMS:', err);\n        res.status(500).send(err);\n    });\n});\n\nconst PORT = process.env.PORT || 3000;\napp.listen(PORT, () => {\n    console.log(`Server is running on port ${PORT}`);\n});