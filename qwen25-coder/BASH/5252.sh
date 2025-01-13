:: Clean ClickOnce Manifests\n@echo off\n\nset BASE_DIR=C:\Path\To\Your\Publish\Folder\ncd /d %BASE_DIR%\n\n:: Delete all *.deploy files and regenerate them\ndel /f/q *.*.deploy\n"C:\Program Files (x86)\Microsoft SDKs\Windows\v7.0A\Bin\MageUI.exe" "%BASE_DIR%\Application Files\<YourAppName>_<Version>\*"\n\n:: Re-sign the Application manifest if it was previously signed\n"C:\Program Files (x86)\Microsoft SDKs\ClickOnce\SignTool.exe" sign /f "<Path-To-Your-Certificate>.pfx"  /p "<YourCertificatePassword>" "%BASE_DIR%\YourApplication.application"