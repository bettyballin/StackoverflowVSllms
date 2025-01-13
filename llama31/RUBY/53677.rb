# User model\nclass User < ApplicationRecord\n  has_many :ratings\n  has_many :submissions, through: :ratings\nend\n\n# Submission model\nclass Submission < ApplicationRecord\n  has_many :ratings\n  has_many :users, through: :ratings\nend\n\n# Rating model\nclass Rating < ApplicationRecord\n  belongs_to :user\n  belongs_to :submission\n\n  # Validate uniqueness of user-submission pair\n  validates_uniqueness_of :user_id, scope: :submission_id\nend