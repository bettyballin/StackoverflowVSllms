fields_array = ['field1', 'desc_field', 'fieldx']\nfields_array.each do |field|\n  self.send("#{field}=", 'frog')\nend