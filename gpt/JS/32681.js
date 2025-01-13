const { Client } = require('pg');\nconst WebSocket = require('ws');\n\n// PostgreSQL client setup\nconst pgClient = new Client({\n  connectionString: 'postgresql://user:password@localhost/dbname',\n});\npgClient.connect();\npgClient.query('LISTEN data_update');\n\n// WebSocket server setup\nconst wss = new WebSocket.Server({ port: 8080 });\n\nwss.on('connection', (ws) => {\n  console.log('Client connected');\n});\n\npgClient.on('notification', (msg) => {\n  const payload = JSON.parse(msg.payload);\n  wss.clients.forEach((client) => {\n    if (client.readyState === WebSocket.OPEN) {\n      client.send(JSON.stringify(payload));\n    }\n  });\n});