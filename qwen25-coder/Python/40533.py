import boto3\n\n# Initialize a session using Amazon S3\ns3 = boto3.client('s3')\n\ndef upload_file_with_prefix(bucket_name, file_path, object_key_prefix):\n    # Construct the full object key with prefix\n    object_key = f"{object_key_prefix}/{file_path.split('/')[-1]}"\n    \n    try:\n        # Upload the file to bucket\n        s3.upload_file(file_path, bucket_name, object_key)\n        print(f"File {file_path} uploaded to {bucket_name}/{object_key}")\n    except Exception as e:\n        print(f"Error uploading file: {e}")\n\n# Example usage\nupload_file_with_prefix('my-bucket', '/path/to/image.jpg', 'images/subfolder')