class Category < ApplicationRecord\n  has_many :subcategories, class_name: "Category", foreign_key: "parent_id"\n  belongs_to :parent, class_name: "Category", optional: true\n\n  def self.full_tree\n    find_by_sql(<<-SQL)\n      WITH RECURSIVE category_tree AS (\n          SELECT id, parent_id, title, 1 AS level\n          FROM categories\n          WHERE parent_id IS NULL\n          UNION ALL\n          SELECT c.id, c.parent_id, c.title, ct.level + 1\n          FROM categories c\n          JOIN category_tree ct ON c.parent_id = ct.id\n      )\n      SELECT * FROM category_tree;\n    SQL\n  end\n\n  def self.subtree(category_id)\n    find_by_sql([<<-SQL, category_id])\n      WITH RECURSIVE subcategories AS (\n          SELECT id, parent_id, title, 1 AS level\n          FROM categories\n          WHERE id = ?\n          UNION ALL\n          SELECT c.id, c.parent_id, c.title, sc.level + 1\n          FROM categories c\n          JOIN subcategories sc ON c.parent_id = sc.id\n      )\n      SELECT * FROM subcategories;\n    SQL\n  end\n\n  def self.path_to_root(category_id)\n    find_by_sql([<<-SQL, category_id])\n      WITH RECURSIVE path_to_root AS (\n          SELECT id, parent_id, title\n          FROM categories\n          WHERE id = ?\n          UNION ALL\n          SELECT c.id, c.parent_id, c.title\n          FROM categories c\n          JOIN path_to_root p ON p.parent_id = c.id\n      )\n      SELECT * FROM path_to_root;\n    SQL\n  end\nend