SELECT "OSARCH_ID", MIN("OSARCH") AS "OSARCH"\nFROM "OSARCH"\nINNER JOIN "OS" ON OSARCH.OSARCH_ID = OS.OSARCH_ID\nGROUP BY "OSARCH_ID";