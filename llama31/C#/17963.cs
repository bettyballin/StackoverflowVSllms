DirectoryEntry userEntry = new DirectoryEntry("WinNT://" + domainUser.Replace('\\', '/') + ",User", \n    AuthenticationType: ADS_USE_CLIENT_AUTH);