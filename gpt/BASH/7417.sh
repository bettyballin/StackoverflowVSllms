# Example Web Deploy command\n    msdeploy -verb:sync -source:package='C:\path\to\your\package.zip' -dest:auto,computerName='https://destination-server:8172/msdeploy.axd',username='username',password='password',authType='basic'