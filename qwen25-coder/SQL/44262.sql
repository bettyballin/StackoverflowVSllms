-- Enable full-text search dictionary (if not already enabled)\nCREATE EXTENSION IF NOT EXISTS pg_trgm;\nCREATE TEXT SEARCH CONFIGURATION my_config ( COPY = english );\n\n-- Create GIN indexes \nCREATE INDEX tenants_fts_idx ON tenants USING gin(to_tsvector('my_config', tenant_name || ' ' || additional_info));\nCREATE INDEX landlords_fts_idx ON landlords USING gin(to_tsvector('my_config', landlord_name || ' ' || contact_details));\nCREATE INDEX units_fts_idx ON units USING gin(to_tsvector('my_config', unit_number || ' ' || description));\nCREATE INDEX properties_fts_idx ON properties USING gin(to_tsvector('my_config', property_name || ' ' || address));\nCREATE INDEX vendors_contacts_fts_idx ON vendors_contacts USING gin(to_tsvector('my_config', vendor_name || ' ' || contact_info));\n\n-- Unify search query across tables\nSELECT 'tenants' AS source, id, tenant_name FROM tenants \nWHERE to_tsvector('my_config', tenant_name || ' ' || additional_info) @@ to_tsquery('search_term')\nUNION ALL\nSELECT 'landlords' AS source, id, landlord_name FROM landlords \nWHERE to_tsvector('my_config', landlord_name || ' ' || contact_details) @@ to_tsquery('search_term')\nUNION ALL\nSELECT 'units' AS source, id, unit_number FROM units \nWHERE to_tsvector('my_config', unit_number || ' ' || description) @@ to_tsquery('search_term')\nUNION ALL\nSELECT 'properties' AS source, id, property_name FROM properties \nWHERE to_tsvector('my_config', property_name || ' ' || address) @@ to_tsquery('search_term')\nUNION ALL\nSELECT 'vendors_contacts' AS source, id, vendor_name FROM vendors_contacts \nWHERE to_tsvector('my_config', vendor_name || ' ' || contact_info) @@ to_tsquery('search_term');