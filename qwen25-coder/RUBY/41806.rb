require 'prawn'\n\ndef generate_address_labels(addresses)\n  pdf = Prawn::Document.new(page_layout: :portrait) do\n    text "Address Labels", size: 20, style: :bold, align: :center\n    move_down(20)\n\n    addresses.each_slice(15) do |page_addresses|\n      page_addresses.each_with_index do |address, index|\n        y_position = cursor - (index % 3 * 80)\n        x_position = (index / 3) * 250\n        bounding_box([x_position, y_position], width: 220, height: 70) do\n          text address[:name], size: 12, style: :bold\n          move_down(5)\n          text address[:address_line_1]\n          text address[:address_line_2] unless address[:address_line_2].nil?\n          text "#{address[:city]}, #{address[:state]} #{address[:zip]}"\n        end\n      end\n      start_new_page unless addresses.last == page_addresses.last.flatten.first\n    end\n  end\n\n  pdf.render_file('address_labels.pdf')\nend\n\naddresses = [\n  { name: "John Doe", address_line_1: "123 Elm St", city: "Springfield", state: "IL", zip: "62704" },\n  { name: "Jane Smith", address_line_1: "456 OakLn", city: "Metropolis", state: "NY", zip: "10001" },\n  # Add more addresses as needed\n]\n\ngenerate_address_labels(addresses)