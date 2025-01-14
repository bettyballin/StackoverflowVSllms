-- First, calculate the hash for the image you want to compare\nDECLARE @Image VARBINARY(MAX) = ... -- your image here\nDECLARE @ImageHash VARBINARY(32) = HASHBYTES('SHA2_256', @Image)\n\n-- Now, compare the hash with the images stored in the database\nSELECT *\nFROM Photos\nWHERE HASHBYTES('SHA2_256', [Photo]) = @ImageHash