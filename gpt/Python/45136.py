import messagebird\n\n     client = messagebird.Client('your_access_key')\n\n     msg = client.message_create(\n         originator='YourName',\n         recipients=['+3197010260001'],\n         body='Hello World'\n     )\n\n     print(msg)