-- Fetch positions\nSELECT position FROM chapters WHERE title IN ('Form vs. Function', 'Accessibility');\n\n-- Assume 'Form vs. Function' has position 3.0 and 'Accessibility' has position 2.0\n-- New 'Form' position will be (2.0 + 3.0) / 2 = 2.5\n\n-- Update position\nUPDATE chapters SET position = 2.5 WHERE title = 'Form vs. Function';