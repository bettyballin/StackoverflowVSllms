class Task < ApplicationRecord\n  belongs_to :project\n\n  validates :name, presence: true\n\n  def validate\n    if project.tasks.exists?(name: name)\n      errors.add(:name, "already exists in this project")\n    end\n  end\nend