require 'vendor/autoload.php';\n\nuse Aws\SecretsManager\SecretsManagerClient;\nuse Aws\Exception\AwsException;\n\n$client = new SecretsManagerClient([\n    'region' => 'us-west-2', // change to your region\n    'version' => '2017-10-17',\n    'credentials' => [\n        'key' => '<YOUR_ACCESS_KEY>',\n        'secret' => '<YOUR_SECRET_KEY>',\n    ],\n]);\n\n$secretName = "my-secrets";\ntry {\n    $result = $client->getSecretValue([\n        'SecretId' => $secretName,\n    ]);\n    if (isset($result['SecretString'])) {\n        $secret = json_decode($result['SecretString'], true);\n        // Use $secret['access_key_id'] and $secret['secret_access_key']\n    }\n} catch (AwsException $e) {\n    echo "Error: " . $e->getMessage();\n}