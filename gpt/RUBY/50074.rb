# Gemfile\n    gem 'rolify'\n\n    # app/models/role.rb\n    class Role < ApplicationRecord\n      has_and_belongs_to_many :users, join_table: :users_roles\n      belongs_to :resource, polymorphic: true, optional: true\n\n      validates :resource_type,\n                inclusion: { in: Rolify.resource_types },\n                allow_nil: true\n\n      scopify\n    end\n\n    # app/models/user.rb\n    class User < ApplicationRecord\n      rolify\n    end