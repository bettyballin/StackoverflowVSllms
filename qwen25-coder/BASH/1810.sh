# Ensure Windows Authentication is Enabled with NTLM, Anonymous is disabled\n  Set-WebConfigurationProperty -pspath 'IIS:\Sites\YourSite\secure' -filter "system.webServer/security/authentication/windowsAuthentication" -name "enabled" -value "True"\n  Set-WebConfigurationProperty -pspath 'IIS:\Sites\YourSite\secure' -filter "system.webServer/security/authentication/anonymousAuthentication" -name "enabled" -value "False"