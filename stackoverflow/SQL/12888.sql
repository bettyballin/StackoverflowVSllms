IF (ISNULL(@fooInt, 0) = 0)\nBEGIN\n    RAISERROR('Invalid parameter: @fooInt cannot be NULL or zero', 18, 0)\n    RETURN\nEND\n\nIF (ISNULL(@fooString, '') = '')\nBEGIN\n    RAISERROR('Invalid parameter: @fooString cannot be NULL or empty', 18, 0)\n    RETURN\nEND