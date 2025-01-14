SELECT DISTINCT provisions.id \nFROM provisions \nLEFT OUTER JOIN provisions_requirements \n  ON provisions_requirements.provision_id = provisions.id \nLEFT OUTER JOIN requirements \n  ON requirements.id = provisions_requirements.requirement_id \nWHERE (requirements.id IS NULL OR requirements.id NOT IN (4))\nLIMIT 0, 10;