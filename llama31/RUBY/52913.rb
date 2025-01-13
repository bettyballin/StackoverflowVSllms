class Product < ApplicationRecord\n  alias_attribute :original_brand, :brand\n\n  def brand\n    original_brand.titleize\n  end\nend