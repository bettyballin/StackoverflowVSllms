# spec/spec_helper.rb (or test/test_helper.rb)\n\nbefore(:suite) do\n  # Load fixtures\n  ActiveRecord::FixtureSet.create_fixtures(Rails.root.join('spec/fixtures'))\nend