const level = require('level');\nconst db = level('./mydb');\n\n// Put a key & value\ndb.put('name', 'Alice', function (err) {\n  if (err) return console.log('Ooops!', err);\n\n  // Fetch by key\n  db.get('name', function (err, value) {\n    if (err) return console.log('Ooops!', err);\n\n    console.log('name=' + value);\n  });\n});