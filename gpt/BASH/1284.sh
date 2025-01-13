# Open a PowerShell prompt as an administrator\n$cert = Get-ChildItem -Path Cert:\CurrentUser\My | Where-Object { $_.Subject -like "*Your Certificate Subject*" }\n\n# Sign the assembly\n& "C:\Program Files (x86)\Microsoft SDKs\Windows\v7.1A\Bin\signtool.exe" sign /f $cert.PfxFilePath /p "YourPassword" /t http://timestamp.digicert.com /v "Path\To\YourAssembly.dll"