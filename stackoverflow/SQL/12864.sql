SELECT id, value, MIN(Signal), MIN(Read), MIN(Firmware), MIN(Date), MIN(Time)\nFROM\n  ...\nGROUP BY\n  ID, Value