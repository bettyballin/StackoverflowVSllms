USE YourDatabase;\n   GO\n\n   CREATE ASSEMBLY YourAssemblyName \n   FROM 'C:\Path\To\YourAssembly.dll'\n   WITH PERMISSION_SET = SAFE;