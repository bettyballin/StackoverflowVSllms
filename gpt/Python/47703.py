import boto3\n     from botocore.exceptions import NoCredentialsError\n\n     def upload_to_s3(file_name, bucket, object_name=None):\n         s3_client = boto3.client('s3')\n         try:\n             s3_client.upload_file(file_name, bucket, object_name or file_name)\n             print(f'Successfully uploaded {file_name} to {bucket}')\n         except FileNotFoundError:\n             print(f'The file {file_name} was not found')\n         except NoCredentialsError:\n             print('Credentials not available')\n\n     file_name = 'path_to_your_archive.zip'\n     bucket_name = 'your_s3_bucket_name'\n     upload_to_s3(file_name, bucket_name)