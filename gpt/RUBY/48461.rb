class Item < ApplicationRecord\n  def self.autocomplete(query)\n    where("name LIKE ?", "%#{query}%").pluck(:name)\n  end\nend