DirectoryEntry userDirectoryEntry; // you need to new this up\nIExchangeMailbox exchangeMailbox = (IExchangeMailbox)userDirectoryEntry.NativeObject;\nIADsSecurityDescriptor securityDescriptor = (IADsSecurityDescriptor) exchangeMailbox.MailboxRights;   \nIADsAccessControlList acl = (IADsAccessControlList) securityDescriptor.DiscretionaryAcl;\n// Iterate thru each ACE in the ACL\nforeach ( IADsAccessControlEntry ace in acl)\n{\n     // in here, you'll have access to each "ace"\n}                                