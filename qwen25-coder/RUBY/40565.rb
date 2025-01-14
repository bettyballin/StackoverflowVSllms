# app/models/post.rb\nclass Post < ApplicationRecord\n  attr_readonly :post_type\n\n  validates_inclusion_of :post_type, in: ['Q', 'A']\n\n  has_one :question, primary_key: [:id, :post_type], foreign_key: [:post_id, :post_type], conditions: { post_type: 'Q' }, class_name: 'Question'\n  has_one :answer, primary_key: [:id, :post_type], foreign_key: [:post_id, :post_type], conditions: { post_type: 'A' }, class_name: 'Answer'\n\n  # If you want to get comments from a generic post\n  has_many :comments, foreign_key: :post_id\n\n  def self.questions\n    where(post_type: 'Q')\n  end\n\n  def self.answers\n    where(post_type: 'A')\n  end\nend\n\n# app/models/question.rb\nclass Question < ApplicationRecord\n  belongs_to :post, primary_key: [:id, :post_type], foreign_key: [:post_id, :post_type], conditions: { post_type: 'Q' }\n\n  has_many :answers, foreign_key: :question_id\nend\n\n# app/models/answer.rb\nclass Answer < ApplicationRecord\n  belongs_to :post, primary_key: [:id, :post_type], foreign_key: [:post_id, :post_type], conditions: { post_type: 'A' }\n  belongs_to :question, foreign_key: :question_id\nend\n\n# app/models/comment.rb\nclass Comment < ApplicationRecord\n  belongs_to :post, foreign_key: :post_id\nend