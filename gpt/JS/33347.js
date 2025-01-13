const express = require('express');\n   const bodyParser = require('body-parser');\n   const stripe = require('stripe')('your-secret-key-here');\n\n   const app = express();\n   app.use(bodyParser.json());\n\n   app.post('/charge', async (req, res) => {\n     const { token } = req.body;\n\n     try {\n       const charge = await stripe.charges.create({\n         amount: 2000, // Amount in cents\n         currency: 'usd',\n         source: token,\n         description: 'Example charge'\n       });\n       res.send({ success: true });\n     } catch (error) {\n       res.status(500).send({ error: error.message });\n     }\n   });\n\n   app.listen(3000, () => console.log('Server listening on port 3000'));