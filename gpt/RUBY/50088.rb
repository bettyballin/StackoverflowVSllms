class MyDateOnlyModel < ActiveRecord::Base\n  # Override the effective_date reader method to return a Date object\n  def effective_date\n    read_attribute(:effective_date).to_date\n  end\nend