class MyModel < ActiveRecord::Base\n  def touch\n    update_attribute(:updated_at, Time.now)\n  end\nend