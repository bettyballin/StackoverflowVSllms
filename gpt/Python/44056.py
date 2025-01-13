import boto3\nfrom botocore.exceptions import NoCredentialsError\n\ns3_client = boto3.client('s3')\n\ndef generate_presigned_url(bucket_name, object_name, expiration=3600):\n    try:\n        response = s3_client.generate_presigned_url('put_object',\n                                                    Params={'Bucket': bucket_name,\n                                                            'Key': object_name},\n                                                    ExpiresIn=expiration)\n    except NoCredentialsError:\n        return None\n    return response