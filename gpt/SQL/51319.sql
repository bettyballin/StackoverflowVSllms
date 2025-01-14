SELECT main.Co1, main.Co2, main.Co3, main.Co4\nFROM YourTable AS main\nWHERE main.Co3 = 't' OR main.Co3 = 'r'\n   OR NOT EXISTS (\n       SELECT 1\n       FROM YourTable AS sub\n       WHERE sub.Co1 = main.Co1\n         AND sub.Co2 = main.Co2\n         AND sub.Co3 NOT IN ('t', 'r')\n   )\nORDER BY main.Co1, main.Co2, main.Co4;