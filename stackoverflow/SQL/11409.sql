CREATE TABLE vehicleEAV (\n  vid        INTEGER,\n  attr_name  VARCHAR(20),\n  attr_value VARCHAR(100),\n  PRIMARY KEY (vid, attr_name),\n  FOREIGN KEY (vid) REFERENCES vehicles (vid)\n);