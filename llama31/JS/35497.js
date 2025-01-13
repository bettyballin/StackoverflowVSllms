const { Pool } = require('pg');\n\nconst dbConfig = {\n  user: 'your_username',\n  host: 'your_host',\n  database: 'your_database',\n  password: 'your_password',\n  port: 5432,\n  ssl: {\n    rejectUnauthorized: true,\n    ca: fs.readFileSync('path/to/your/CA/certificate').toString(),\n  },\n};\n\nconst pool = new Pool(dbConfig);\n\n// Use the pool to query the database\npool.query('SELECT * FROM your_table', (err, res) => {\n  if (err) {\n    console.error(err);\n  } else {\n    console.log(res.rows);\n  }\n});