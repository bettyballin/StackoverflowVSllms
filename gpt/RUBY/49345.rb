class YourModel < ApplicationRecord\n  self.record_timestamps = false\n\n  before_create :set_custom_created_at\n  before_update :set_custom_updated_at\n\n  def set_custom_created_at\n    self.custom_created_at = Time.current\n  end\n\n  def set_custom_updated_at\n    self.custom_updated_at = Time.current\n  end\nend