def add_uri(options)\n  options[:builder].tag!('uri', send("#{self.class.name.downcase}_path", self))\n  if options[:depth].nil? || options[:depth] > 0\n    options[:depth] = (options[:depth] || 1) - 1\n    include_related_resources(options)\n  end\nend\n\ndef include_related_resources(options)\n  case self.class.name\n  when 'Employee'\n    options[:builder].tag!('employer', employer.to_xml(options))\n  when 'Employer'\n    options[:builder].tag!('employees', employees.map { |e| e.to_xml(options) })\n  end\nend