-- Using cross join with WHERE clause\nSELECT User.*\nFROM User, Address\nWHERE User.addressId = Address.id;\n\n-- Using inner join\nSELECT User.*\nFROM User\nINNER JOIN Address ON User.addressId = Address.id;