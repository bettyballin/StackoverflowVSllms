int userPermissions = 0;\n\n// Add VIEWUSERS and EDITPRODUCTS to the user's permissions\nuserPermissions = Permissions.addPermission(userPermissions, Permissions.VIEWUSERS);\nuserPermissions = Permissions.addPermission(userPermissions, Permissions.EDITPRODUCTS);\n\n// Store `userPermissions` in your database as an integer.