# app/models/movie.rb\nclass Movie < ApplicationRecord\n  has_many :roles\n  has_many :actors, through: :roles\n  has_many :filming_locations\nend\n\n# app/models/user.rb\nclass User < ApplicationRecord\n  has_many :movies\nend\n\n# app/models/actor.rb\nclass Actor < ApplicationRecord\n  has_many :roles\n  has_many :movies, through: :roles\nend\n\n# app/models/character.rb\nclass Character < ApplicationRecord\n  belongs_to :movie\n  belongs_to :actor\nend\n\n# app/models/filming_location.rb\nclass FilmingLocation < ApplicationRecord\n  belongs_to :movie\nend\n\n# app/models/role.rb\nclass Role < ApplicationRecord\n  belongs_to :movie\n  belongs_to :actor\n  belongs_to :character\nend