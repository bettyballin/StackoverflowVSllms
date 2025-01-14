require 'action_view'\ninclude ActionView::Helpers::SanitizeHelper\n\nclass Post < ActiveRecord::Base\n  before_validation :clean_input\n\n  protected\n\n  def clean_input\n    self.input = sanitize(self.input, tags: %w(b i u))\n  end\nend