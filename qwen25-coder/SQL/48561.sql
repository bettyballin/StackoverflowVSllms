-- More efficient and clear\nSELECT MIN(`field`)\nFROM `tbl`;\n\n-- Less efficient due to sorting\nSELECT `field`\nFROM `tbl`\nORDER BY `field`\nLIMIT 1;