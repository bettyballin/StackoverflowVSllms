require_once 'svn.php';\n\n$client = new SvnClient();\n$info = $client->info('.');\n$revision = $info['entry_revision'];\necho $revision;