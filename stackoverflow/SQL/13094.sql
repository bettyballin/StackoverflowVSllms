INSERT \n  MainTable_Option \n  (\n  MainTableID, \n  OptionID\n  )\nSELECT\n  d.ID, \n  o.OptionId\nFROM\n  DodgyOldTable d\n  INNER JOIN Option o ON\n    (d.OptionVal1 = 'Y' AND o.OptionDesc = 'OptionVal1') OR\n    (d.OptionVal2 = 'Y' AND o.OptionDesc = 'OptionVal2') OR\n    (d.OptionVal3 = 'Y' AND o.OptionDesc = 'OptionVal3')