using System;\nusing System.Management;\n\npublic static void ChangeServiceLogonAccount(string serviceName, string accountName, string password)\n{\n    ConnectionOptions connection = new ConnectionOptions();\n    connection.Impersonation = ImpersonationLevel.Impersonate;\n    \n    ManagementScope scope = new ManagementScope("root\\CIMV2", connection);\n    scope.Connect();\n\n    ManagementObject service = new ManagementObject(scope, new ManagementPath($"Win32_Service.Name='{serviceName}'"), null);\n\n    // Change the service's logon account and password\n    var inParams = service.GetMethodParameters("Change");\n    inParams["StartName"] = accountName;\n    inParams["StartPassword"] = password;\n\n    ManagementBaseObject outParams = service.InvokeMethod("Change", inParams, null);\n    int retValue = Convert.ToInt32(outParams.Properties["ReturnValue"].Value);\n\n    if (retValue == 0)\n    {\n        Console.WriteLine($"Successfully changed the logon account for {serviceName}.");\n    }\n    else\n    {\n        Console.WriteLine($"Failed to change the logon account for {serviceName}. Error code: {retValue}");\n    }\n}