# mycode.rb\n\ndef some_method\n  variable1 = "Hello"\n  variable2 = "World"\n\n  # Adding an IRB breakpoint here\n  binding.irb\n\n  puts "#{variable1}, #{variable2}!"\nend\n\nsome_method