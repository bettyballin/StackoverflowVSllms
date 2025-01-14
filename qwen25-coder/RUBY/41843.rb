# /lib/open_flash_chart_wrapper.rb\nrequire 'open_flash_chart' # Ensure open_flash_chart gem is included and required\n\nmodule OpenFlashChartWrapper\n  def self.create_line_chart(data, options = {})\n    line = Line.new\n    line.values = data\n    chart = OpenFlashChart::Graph.new\n    chart.add_element(line)\n    chart.title = Title.new(options[:title]) if options[:title]\n    chart\n  end\nend