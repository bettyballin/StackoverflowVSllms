require 'get_process_mem'\n\nprocess = GetProcessMem.new(Process.pid)\nputs "Memory Usage: #{(process.bytes / 1024.0).to_i} KB"