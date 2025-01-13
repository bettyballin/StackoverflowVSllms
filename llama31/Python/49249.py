import subprocess\n\nsqlpubwiz = r'"C:\Program Files\Microsoft SQL Server\90\Tools\Publishing\sqlpubwiz.exe"'\nserver = 'myLocalServer'\ndatabase = 'myLocalDatabase'\nconnection_values = ['server=' + server, 'database=' + database, 'trusted_connection=true']\nconnection_string = ';'.join(connection_values)\ndbms_version = '2000'\nsqlscript_filename = 'CreateSchema.sql'\n\nargs = [\n    sqlpubwiz,\n    'script',\n    '-C', connection_string,\n    sqlscript_filename,\n    '-schemaonly',\n    '-targetserver', dbms_version,\n    '-f',\n]\n\nsubprocess.run(args)