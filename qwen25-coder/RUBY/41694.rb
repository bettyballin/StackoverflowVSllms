class User < ApplicationRecord\n  has_many :items\n  has_many :ratings, through: :items\nend