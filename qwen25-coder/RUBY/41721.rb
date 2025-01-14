# model\nclass Model\n  def self.find_current\n    rows = all # use `all` instead of `find(:all)` which is deprecated\n    filter_my_rows(rows)\n  end\n\n  def self.filter_my_rows(rows)\n    # do stuff here on rows\n    rows.reject! { |row| !row.meets_certain_conditions? }\n  end\n\n  private\n\n  def meets_certain_conditions?\n    # your condition logic here\n  end\nend