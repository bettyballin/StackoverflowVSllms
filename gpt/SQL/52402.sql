SELECT * FROM ROUTERS \nWHERE (ROUTER_ADDRESS IS NULL AND ? IS NULL) \n   OR (ROUTER_ADDRESS = ?)