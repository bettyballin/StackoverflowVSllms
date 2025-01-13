[TestMethod]\npublic void SecureSocketLayerSetToTrue()\n{\n    var ldapConnection = new LdapConnection(\n        new LdapDirectoryIdentifier("ldap.test.com", 636));\n    ldapConnection.SessionOptions.StartTlsAsClient = true;\n    ldapConnection.Bind();\n    Assert.IsTrue(ldapConnection.SessionOptions.StartTlsAsClient);\n}