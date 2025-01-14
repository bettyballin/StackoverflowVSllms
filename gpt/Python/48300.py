import boto3\n\nclient = boto3.client('route53')\n\nresponse = client.change_resource_record_sets(\n    HostedZoneId='Z3M3LMPEXAMPLE',\n    ChangeBatch={\n        'Comment': 'Update to point to EC2 instance',\n        'Changes': [\n            {\n                'Action': 'UPSERT',\n                'ResourceRecordSet': {\n                    'Name': 'yourdomain.com',\n                    'Type': 'A',\n                    'TTL': 300,\n                    'ResourceRecords': [{'Value': 'EC2_INSTANCE_IP'}]\n                }\n            }\n        ]\n    }\n)\nprint(response)