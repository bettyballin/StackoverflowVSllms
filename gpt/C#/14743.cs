using System.Security.AccessControl;\n\nstring sddl = "O:BAOG:BAD:(A;;FA;;;SY)(A;;FA;;;BA)";\nRawSecurityDescriptor securityDescriptor = new RawSecurityDescriptor(sddl);\nbyte[] binaryForm = new byte[securityDescriptor.BinaryLength];\nsecurityDescriptor.GetBinaryForm(binaryForm, 0);\n\nSecurityDescriptor sd = new SecurityDescriptor();\nsd.SetSecurityDescriptorBinaryForm(binaryForm);\n\n// Apply the security descriptor to an object, e.g., a file:\n// FileSecurity fileSecurity = new FileSecurity();\n// fileSecurity.SetSecurityDescriptorBinaryForm(sd.BinaryForm);\n// File.SetAccessControl("path_to_file", fileSecurity);