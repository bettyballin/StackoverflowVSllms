var protectedPayload = DataProtectionProvider.Create("YourAppName").CreateProtector("YourProtectionPurpose").Protect(payload);