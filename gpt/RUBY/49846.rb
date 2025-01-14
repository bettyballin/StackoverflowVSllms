class User < ActiveRecord::Base\n  has_many :follows, foreign_key: 'follower_id', class_name: 'Follow'\n  has_many :followers, through: :follows\n  has_many :followed, foreign_key: 'followee_id', class_name: 'Follow'\n  has_many :followees, through: :followed\n  has_many :messages\nend\n\nclass Follow < ActiveRecord::Base\n  belongs_to :follower, class_name: 'User'\n  belongs_to :followee, class_name: 'User'\nend\n\nclass Message < ActiveRecord::Base\n  belongs_to :user\nend\n\n# Fetching the feed for the current user\ndef feed_for(current_user)\n  Message.joins(user: :followers)\n         .where(follows: { follower_id: current_user.id })\n         .order('messages.created_at DESC')\nend