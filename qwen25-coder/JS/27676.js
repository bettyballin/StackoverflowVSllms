const axios = require('axios');\n\n// Function to make a call from the IP phone\nasync function makeCall(phoneNumber) {\n    try {\n        const response = await axios.post(\n            'https://api.yourprovider.com/calls/initiate',\n            { number: phoneNumber },\n            {\n                headers: {\n                    'Authorization': `Bearer ${YOUR_ACCESS_TOKEN}`,\n                    'Content-Type': 'application/json'\n                }\n            }\n        );\n        console.log('Call initiated:', response.data);\n    } catch (error) {\n        console.error('Error initiating call:', error.response ? error.response.data : error.message);\n    }\n}\n\n// Example usage\nmakeCall('+1234567890');