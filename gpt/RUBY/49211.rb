class User < ApplicationRecord\n  validates_inclusion_of :new_field, in: %w(option1 option2), if: -> { new_field.present? }\nend