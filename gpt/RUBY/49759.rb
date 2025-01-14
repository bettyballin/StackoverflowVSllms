class DataType1 < ApplicationRecord\n  has_many :data_type2s, inverse_of: :data_type1\n  accepts_nested_attributes_for :data_type2s, allow_destroy: true\nend\n\nclass DataType2 < ApplicationRecord\n  belongs_to :data_type1\nend