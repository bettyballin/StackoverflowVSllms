class Foo < ActiveRecord::Base\n   attr_accessor :humanproof\n\n   def validate\n     errors.add(:humanproof, "is not the right answer") if humanproof != 4\n   end