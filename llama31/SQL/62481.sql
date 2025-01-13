CREATE TABLE EntityA_EntityB_History (\n  EntityAId INT,\n  EntityBId INT,\n  ValidStart DATETIME,\n  ValidEnd DATETIME,\n  EventType VARCHAR(10) CHECK (EventType IN ('INSERT', 'UPDATE', 'DELETE')),\n  PRIMARY KEY (EntityAId, EntityBId, ValidStart),\n  FOREIGN KEY (EntityAId) REFERENCES EntityA(Id),\n  FOREIGN KEY (EntityBId) REFERENCES EntityB(Id)\n);