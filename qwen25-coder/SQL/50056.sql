WITH RECURSIVE subcategories AS (\n    SELECT category_id FROM categories WHERE category_id = ? -- Replace '?' with your target category ID\n    UNION ALL\n    SELECT c.category_id\n    FROM categories c\n    JOIN subcategories s ON c.parent_id = s.category_id\n)\nSELECT DISTINCT o.organization_id, o.organization_name\nFROM organizations o\nJOIN organizations_categories oc ON o.organization_id = oc.organization_id\nJOIN subcategories s ON oc.category_id = s.category_id;