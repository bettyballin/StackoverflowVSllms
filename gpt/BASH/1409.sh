# Open PowerShell as Administrator and run the following commands to set the anonymous user\nImport-Module WebAdministration\nSet-WebConfigurationProperty -pspath 'MACHINE/WEBROOT/APPHOST' -filter "system.webServer/security/authentication/anonymousAuthentication" -name "userName" -value "username"\nSet-WebConfigurationProperty -pspath 'MACHINE/WEBROOT/APPHOST' -filter "system.webServer/security/authentication/anonymousAuthentication" -name "password" -value "password"