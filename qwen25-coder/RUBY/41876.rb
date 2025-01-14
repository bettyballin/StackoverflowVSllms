class Person < ActiveRecord::Base\n  belongs_to :father, class_name: 'Person'\n  belongs_to :mother, class_name: 'Person'\n\n  has_many :children_as_mother, class_name: 'Person', foreign_key: :mother_id\n  has_many :children_as_father, class_name: 'Person', foreign_key: :father_id\n\n  # If you want a combined list of all children, you can define this method:\n  def children\n    children_as_mother + children_as_father\n  end\nend