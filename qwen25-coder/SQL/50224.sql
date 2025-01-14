WITH maxA AS (\n    SELECT MAX(`A`) * 2 AS maxVal FROM `aTable`\n)\nINSERT INTO `aTable` (`A`, `B`)\nSELECT maxVal, 'name' FROM maxA;