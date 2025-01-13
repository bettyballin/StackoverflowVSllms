class Task < ApplicationRecord\n  belongs_to :project\n\n  validates :name, presence: true\n  validates_uniqueness_of :name, scope: :project_id\nend