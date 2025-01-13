LOAD DATA\nAPPEND\nINFILE 'datafile.dat'\nBADFILE 'badfile.bad'\nDISCARDFILE 'discardfile.dsc'\n\nINTO TABLE position\nWHEN (1:3) = 'POS'\nFIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'\n(\n  column1      CHAR(10),\n  column2      CHAR(10),\n  column3      CHAR(1),\n  column4      CHAR(1),\n  column5      CHAR(15)\n)\n\nLOAD DATA\nAPPEND\nINFILE 'datafile.dat'\nBADFILE 'badfile.bad'\nDISCARDFILE 'discardfile.dsc'\n\nINTO TABLE sec_desc\nWHEN (1:3) = 'SEC'\nFIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'\n(\n  column1      CHAR(10),\n  column2      CHAR(2),\n  column3      CHAR(30),\n  column4      CHAR(30),\n  column5      CHAR(15),\n  column6      CHAR(15),\n  column7      CHAR(10),\n  column8      CHAR(10)\n)\n\nLOAD DATA\nAPPEND\nINFILE 'datafile.dat'\nBADFILE 'badfile.bad'\nDISCARDFILE 'discardfile.dsc'\n\nINTO TABLE customer\nWHEN (1:3) = 'CUS'\nFIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'\n(\n  column1      CHAR(10),\n  column2      CHAR(30),\n  column3      CHAR(20),\n  column4      CHAR(20),\n  column5      CHAR(15),\n  column6      CHAR(30),\n  column7      CHAR(15),\n  column8      CHAR(15),\n  column9      CHAR(10),\n  column10     CHAR(10),\n  column11     CHAR(10),\n  column12     CHAR(10)\n)