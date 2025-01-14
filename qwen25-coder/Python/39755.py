import boto3\n\n# Create an S3 client\ns3 = boto3.client('s3')\n\n# Call to list existing buckets\nresponse = s3.list_buckets()\n\n# Output the bucket names\nprint('Existing buckets:')\nfor bucket in response['Buckets']:\n    print(f'  {bucket["Name"]}')