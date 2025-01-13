require 'rubygems'\nrequire 'csv'\n\ndesc <<-END_DESC\nBulk loading of issues from a CSV file.\n\nAvailable options:\n * filepath => path to the text file.\n * project => id or identifier of project\n\nExample:\n rake redmine:csv_import filepath="~/import.csv" project="askiavista"\nEND_DESC\n\nnamespace :redmine do\n  task :csv_import => :environment do\n    firstrow = true\n    count = 1\n\n    CSV.foreach(ENV['filepath']) do |row|\n      unless firstrow\n        issue = Issue.new\n        issue.project = Project.find_by_name(ENV['project'])\n\n        # If not a feature it's a bug\n        if row[3].include?("SUG")\n          issue.tracker = Tracker.find_by_id(2)\n        else\n          issue.tracker = Tracker.find_by_id(1)\n        end\n\n        if row[4].include?("TOP PRIORITY")\n          issue.priority = Enumeration.find_by_id(7)\n        elsif row[4].include?("HIGH PRIORITY")\n          issue.priority = Enumeration.find_by_id(5)\n        elsif row[4].include?("MEDIUM PRIORITY")\n          issue.priority = Enumeration.find_by_id(4)\n        else\n          issue.priority = Enumeration.find_by_id(3)\n        end\n\n        issue.author = User.find(5)\n        issue.subject = row[4][0, 50]  # Truncate to 50 characters\n        issue.description = row[4]\n        issue.status = IssueStatus.find_by_id(1)\n        issue.save\n        count += 1\n      end\n      firstrow = false\n    end\n  end\nend