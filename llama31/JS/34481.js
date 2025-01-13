// Web frontend (consumer)\nconst amqp = require('amqplib');\n\nasync function consumeMessage() {\n  const connection = await amqp.connect('amqp://localhost');\n  const channel = await connection.createChannel();\n\n  await channel.assertQueue('job_complete', { durable: false });\n\n  console.log('Waiting for messages...');\n\n  channel.consume('job_complete', (msg) => {\n    if (msg !== null) {\n      console.log(msg.content.toString());\n      // Update the UI to reflect the completed job\n    }\n  }, { noAck: true });\n}