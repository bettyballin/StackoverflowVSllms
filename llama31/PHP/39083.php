$regex = '/' .\n    // Match the word in braces\n    '\{(\w+)\}' .\n    // Only if it is followed by an even number of single-quotes\n    '(?=(?:[^\\\']*(?:\\\\.[^\\\']*)*\')*[^\']*$)' .\n    // The end\n    '/';