class Category < ApplicationRecord\n        has_many :children, class_name: "Category", foreign_key: "parent_id"\n        belongs_to :parent, class_name: "Category", optional: true\n    end