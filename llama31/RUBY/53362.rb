class User < ActiveRecord::Base\n  def admin?\n    admin == 't'\n  end\nend