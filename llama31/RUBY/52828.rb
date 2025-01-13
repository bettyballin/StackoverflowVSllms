require 'time'\n\nclass ProductivityTracker\n  def initialize\n    @start_time = Time.now\n  end\n\n  def track_time(task_name)\n    @end_time = Time.now\n    elapsed_time = @end_time - @start_time\n    puts "Task '#{task_name}' took #{elapsed_time} seconds"\n    @start_time = Time.now\n  end\nend\n\ntracker = ProductivityTracker.new\ntracker.track_time("Coding task 1")\n# ... do some coding ...\ntracker.track_time("Coding task 2")