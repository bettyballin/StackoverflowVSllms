-- Tables for Entity Types\nTables:\n    EntityType [EntityTypeID, EntityTypeName] \n        -- (e.g., Company=1, Employee=2, etc.)\n\nEntity [EntityID, EntityTypeID]\n    : EntityTypeID => EntityType\n\nCompany [CompanyID, EntityID, CompanyName, ...]\n    : EntityID => Entity\n\nEmployee [EmployeeID, EntityID, FirstName, LastName, ...]\n    : EntityID => Entity\n\nAddressType [AddressTypeID, AddressTypeName]\n    -- (e.g., Primary=1, Mailing=2, etc.)\n\n-- Linking table for Addresses\nEntityAddress [EntityAddressID, EntityID, AddressTypeID, StreetAddress1, City, State, ZipCode]\n    : EntityID => Entity\n    : AddressTypeID => AddressType\n\n-- Other common attributes can have similar linking tables\n-- Example: ContactDetails\nContactDetailType [ContactDetailTypeID, ContactDetailTypeName]\n\nEntityContactDetail [EntityContactDetailID, EntityID, ContactDetailTypeID, DetailValue]\n    : EntityID => Entity\n    : ContactDetailTypeID => ContactDetailType