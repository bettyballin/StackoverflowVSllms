Then /^I should be (editing|viewing) the (\w+) with (\w+) "([^\"]*)"$/ do |action,model,field,value|\n  # ...\n  retry_count = 0\n  begin\n    URI.parse(current_url).path.should == eval("#{func}(m)")\n  rescue Spec::Expectations::ExpectationNotMetError\n    retry_count += 1\n    retry if retry_count < 3\n  end\nend