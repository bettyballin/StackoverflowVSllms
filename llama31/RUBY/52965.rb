# lib/tasks/my_script.rake\nnamespace :my_script do\n  desc "Run my script"\n  task execute: :environment do\n    MyScript.new.execute\n  end\nend