aws s3api put-bucket-acl --bucket <bucket-name> --grant-read 'uri="http://acs.amazonaws.com/groups/global/AllUsers"' --grant-write 'uri="http://acs.amazonaws.com/groups/global/AllUsers"'