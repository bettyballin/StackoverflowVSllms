aws ec2 run-instances --image-id ami-a83fabc0 --count 20 --instance-type t2.micro --iam-instance-profile Name=YourIAMRoleName --key-name YourKeyPairName