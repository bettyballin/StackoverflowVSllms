# Daemon (producer)\nimport pika\n\nconnection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))\nchannel = connection.channel()\n\n# Process the job...\n# ...\n\n# Send a message to the web frontend when processing is complete\nchannel.basic_publish(exchange='',\n                      routing_key='job_complete',\n                      body='Job complete!')\n\nconnection.close()