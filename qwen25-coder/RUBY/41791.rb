class MyFormObject\n  include ActiveModel::Model\n\n  attr_accessor :story_title, :content\n\n  def persisted?\n    false\n  end\nend