class User < ActiveRecord::Base\n  after_save :do_activate, if: -> { active_changed? && active }\n\n  def do_activate\n    self.create_pen # Assuming there is a method to create associated pen\n    self.create_notebook # Assuming there is a method to create associated notebook\n  end\nend