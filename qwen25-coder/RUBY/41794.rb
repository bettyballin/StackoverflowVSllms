def test_create_with_valid_inclusion\n     Rails.logger.debug "Valid inclusion values: #{RelatedModel.inclusion_values.inspect}"\n     assert blah = Blah.create!(valid_attributes)\n   end