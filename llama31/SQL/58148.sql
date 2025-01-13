SELECT DISTINCT `provisions`.id \nFROM `provisions` \nLEFT JOIN `provisions_requirements` ON `provisions_requirements`.provision_id = `provisions`.id \nLEFT JOIN `requirements` ON `requirements`.id = `provisions_requirements`.requirement_id \nWHERE `requirements`.id NOT IN (4) OR `requirements`.id IS NULL\nLIMIT 0, 10