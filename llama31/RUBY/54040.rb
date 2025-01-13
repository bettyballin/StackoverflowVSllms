module Something\n  def self.included(base)\n    base.validates :name\n    base.validates :date\n  end\nend\n\nmodule Anotherthing\n  def self.included(base)\n    base.validates :age\n  end\nend\n\nclass ADualClass\n  include Something\n  include Anotherthing\nend