-- Breakdown of the right side calculation:\n-- LENGTH(@q) - LENGTH(REPLACE(@q, ',', '')) + 1 gives the number of values in @q.\n-- (1 << numValues) - 1 creates a binary number with bits set to 1 at positions for all questions.