-- Example of inserting a new image and flag without resolution type\nINSERT INTO tblImages (...) VALUES (...);\n\nINSERT INTO tblImageFlags (imageID, flagTypeID, resolutionTypeID) VALUES (1, 1, NULL);