# Example Widget model in Rails\nclass Widget < ApplicationRecord\n  validates :name, presence: true\n  # other fields like configuration_json, description, etc.\nend