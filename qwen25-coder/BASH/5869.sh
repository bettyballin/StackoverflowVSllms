@echo off\n\nREM Step 1: Launch EC2 instance and capture the InstanceId\nfor /f "tokens=2 delims= " %%i in ('aws ec2 run-instances --image-id ami-0c55b159cbfafe1f0 --count 1 --instance-type t2.micro --key-name MyKeyPair --security-group-ids sg-903004f8 --subnet-id subnet-6e7f829e ^| findstr "InstanceId"') do set InstanceId=%%i\n\necho Launched instance with ID: %InstanceId%\n\nREM Step 2: Wait for the instance to enter running state\n:check_status\naws ec2 describe-instances --instance-ids %InstanceId% | findstr -q "\"State\": {\"Name\": \"running\"" && goto associate_ip || timeout /t 10 > nul & goto check_status\n\nREM Step 3: Associate Elastic IP with the instance\naws ec2 associate-address --instance-id %InstanceId% --allocation-id eipalloc-64d5890a\n\necho Successfully associated EIP with %InstanceId%\n\ngoto end\n\n:associate_ip\n:wait_for_running\necho Waiting for instance to reach running state...\n\n:end