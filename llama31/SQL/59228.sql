SELECT * \nFROM ROUTERS \nWHERE (ROUTER_ADDRESS = ? OR (ROUTER_ADDRESS IS NULL AND ? IS NULL));