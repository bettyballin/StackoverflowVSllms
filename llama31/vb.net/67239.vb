Dim rsa As New RSACryptoServiceProvider()\n rsa.PersistKeyInCsp = True\n rsa.ContainerName = "NetFrameworkConfigurationKey"\n rsa.Delete()