require 'rubygems'\nrequire 'fastercsv'\n\n# csv issues import for redmine\n# Will convert a csv into a issues bulkloader into redmine\n# Column names\n# row[0]=Nb Number,row[1]=Product,row[2]=Element,row[3]=Type,row[4]=Queue,\n# row[5]=KeyWord,row[6]=Responsible,row[7]=Case Descriptions,row[8]=Days,\n# row[9]=Planned Delivery,row[10]=Version\n\ndesc <<-END_DESC\nBulk loading of issues from a CSV file.\n\nAvailable options:\n  * filepath    => path to the text file.\n  * project     => id or identifier of project\n\nExample:\n  rake redmine:csv_import filepath="~/import.csv" project="askiavista"\nEND_DESC\n\nnamespace :redmine do\n  task :csv_import => :environment do\n    @firstrow = true\n    @count = 1\n\n    FasterCSV.foreach(ENV['filepath']) do |row|\n      if not @firstrow\n        @i = Issue.new\n        @i.project = Project.find_by_name(ENV['project'])\n        # If not a feature it's a bug\n        if row[3].include?("SUG")\n          @i.tracker = Tracker.find_by_id(2)\n        else\n          @i.tracker = Tracker.find_by_id(1)\n        end\n\n        if row[4].include?("TOP PRIORITY")\n          @i.priority = Enumeration.find_by_id(7)\n        elsif row[4].include?("HIGH PRIORITY")\n          @i.priority = Enumeration.find_by_id(5)\n        elsif row[4].include?("MEDIUM PRIORITY")\n          @i.priority = Enumeration.find_by_id(4)\n        else\n          @i.priority = Enumeration.find_by_id(3)\n        end\n\n        @i.author = User.find(5)\n        @i.subject = truncate(row[4], 50)\n        @i.description = row[4]\n        @i.status = IssueStatus.find_by_id(1)\n        @i.save\n        @count += 1\n      end\n      @firstrow = nil\n    end\n  end\nend