require 'vendor/autoload.php';\n\nuse Aws\S3\S3Client;\n\n$s3Client = new S3Client([\n    'version' => 'latest',\n    'region'  => 'us-east-1',\n    'credentials' => [\n        'key' => 'YOUR_ACCESS_KEY',\n        'secret' => 'YOUR_SECRET_KEY',\n    ],\n]);\n\n$bucketName = 'your-bucket-name';\n$file = $_FILES['file']['tmp_name'];\n$fileName = $_FILES['file']['name'];\n\n$result = $s3Client->putObject([\n    'Bucket' => $bucketName,\n    'Key'    => $fileName,\n    'SourceFile' => $file,\n]);\n\necho $result['ObjectURL'];