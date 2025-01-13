# Avoid single-line blocks for complex logic\nitems.each { |item| process(item) if item.valid? && item.enabled? }\n\n# Prefer multi-line blocks for clarity\nitems.each do |item|\n  if item.valid? && item.enabled?\n    process(item)\n  end\nend