class User < ApplicationRecord\n  validates :email, presence: true\n  validate :custom_email_validation\n\n  def custom_email_validation\n    errors.add(:email, "Invalid email format") unless email =~ /\A([^@\s]+)@((?:[-a-z0-9]+\.)+[a-z]{2,})\z/i\n  end\nend