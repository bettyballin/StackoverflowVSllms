$bucket = 'your-bucket-name';\n$objectKey = 'path/to/your/flv/file.flv';\n$expires = time() + 3600; // 1 hour expiration\n$secretKey = 'YOUR_AWS_SECRET_KEY';\n\n$stringToSign = "GET\n\n\n$expires\n/$bucket/$objectKey";\n$signature = urlencode(base64_encode(hash_hmac('sha1', $stringToSign, $secretKey, true)));\n\n$signedUrl = "https://$bucket.s3.amazonaws.com/$objectKey?AWSAccessKeyId=YOUR_AWS_ACCESS_KEY&Signature=$signature&Expires=$expires";