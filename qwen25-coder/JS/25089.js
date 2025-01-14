const { Storage } = require('@google-cloud/storage');\n\nexports.helloWorld = async (req, res) => {\n  const storage = new Storage();\n  try {\n    // Lists all buckets in the current project\n    const [buckets] = await storage.getBuckets();\n    console.log('Buckets:');\n    buckets.forEach(bucket => {\n      console.log(bucket.name);\n    });\n    res.status(200).send(JSON.stringify(buckets.map(bucket => bucket.name)));\n  } catch (err) {\n    res.status(500).send(`Error: ${err.message}`);\n  }\n};