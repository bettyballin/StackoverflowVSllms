# Install IIS and FTP server\nImport-Module ServerManager\nAdd-WindowsFeature Web-Server, Web-Ftp-Server, Web-Management-Tools\n\n# Create FTP site\nImport-Module WebAdministration\nNew-WebFtpSite -Name "MyFTPSite" -Port 21 -PhysicalPath "C:\inetpub\ftproot" -AllowRead $true -AllowWrite $true\n\n# Set up authentication\nSet-WebConfigurationProperty -filter "system.ftpServer/security/authentication/anonymousAuthentication" -name "enabled" -value $false -PSPath "IIS:\"\nSet-WebConfigurationProperty -filter "system.ftpServer/security/authentication/basicAuthentication" -name "enabled" -value $true -PSPath "IIS:\"\n\n# Add FTP user isolation\nSet-WebConfigurationProperty -filter "system.ftpServer/userIsolation" -name "mode" -value "Isolated" -PSPath "IIS:\"