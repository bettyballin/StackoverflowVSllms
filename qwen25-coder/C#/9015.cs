// Use ServiceSecurityContext to get current principle\n   WindowsIdentity identity = ServiceSecurityContext.Current.PrimaryIdentity;\n   string userName = identity.Name;  // retrieves the username