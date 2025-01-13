// Generate a signed URL on your server\nconst AWS = require('aws-sdk');\nconst s3 = new AWS.S3({\n  accessKeyId: 'YOUR_ACCESS_KEY',\n  secretAccessKey: 'YOUR_SECRET_KEY',\n});\n\nconst params = {\n  Bucket: 'your-bucket-name',\n  Key: 'path/to/object',\n  ContentType: 'video/mp4',\n};\n\ns3.getSignedUrl('putObject', params, (err, data) => {\n  if (err) {\n    console.log(err);\n  } else {\n    const signedUrl = data;\n    // Send the signed URL to the client\n  }\n});