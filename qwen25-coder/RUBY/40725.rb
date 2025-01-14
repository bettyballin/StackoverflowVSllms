class YourModel < ApplicationRecord\n  # Define the attributes for each step\n  attr_accessor :step1_params, :step2_params\n\n  validate :validate_step1_fields, on: :save_step1\n  validate :validate_step2_fields, on: :save_step2\n\n  def validate_step1_fields\n    errors.add(:field1, 'cannot be blank') if field1.blank?\n    errors.add(:field2, 'must be a number') unless field2.match(/\A[0-9]+\z/)\n  end\n\n  def validate_step2_fields\n    errors.add(:field3, 'is invalid') unless valid_email?(field3)\n  end\n\n  private\n\n  def valid_email?(email)\n    # Simple regex for email validation\n    !!(email =~ /\A[\w+\-.]+@[a-z\d\-.]+\.[a-z]+\z/i)\n  end\nend