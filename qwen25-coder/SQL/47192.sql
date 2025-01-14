-- Table for storing vessel fuel consumption data\nCREATE TABLE VesselFuelConsumption (\n    VesselID INT PRIMARY KEY,\n    AtPortIFOType NVARCHAR(3),\n    AtPortMFOType NVARCHAR(3),\n    SailingIFOType NVARCHAR(3),\n    SailingMFOType NVARCHAR(3),\n    AtPortIFOConsumption DECIMAL(10, 2),\n    AtPortMFOConsumption DECIMAL(10, 2),\n    SailingIFOConsumption DECIMAL(10, 2),\n    SailingMFOConsumption DECIMAL(10, 2)\n);