@echo off\n%windir%\system32\inetsrv\appcmd add apppool /name:"MyCustomAppPool" /managedRuntimeVersion:v4.0 /processModel.identityType:SpecificUser /processModel.userName:"domain\username" /processModel.password:"password"