module ResourceSerializer\n  def to_xml(options = {})\n    options[:procs] = [ Proc.new { |options| add_uri(options) } ]\n    super(options)\n  end\n\n  private\n\n  def add_uri(options)\n    options[:builder].tag!('uri', send("#{self.class.name.downcase}_path", self))\n  end\nend