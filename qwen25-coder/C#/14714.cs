// Create a FileIOPermission object with Delete access for the specified directory\nFileIOPermission deletePermit = new FileIOPermission(FileIOPermissionAccess.Delete, _ArchiveHome);\n// Demand the permission\ndeletePermit.Demand();