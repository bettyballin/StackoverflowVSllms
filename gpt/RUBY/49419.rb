# config/initializers/sql_logger.rb\nmodule ActiveRecord\n  class LogSubscriber\n    def sql(event)\n      return unless logger.debug?\n\n      payload = event.payload\n      name = "#{payload[:name]} (#{event.duration.round(1)}ms)"\n      sql = payload[:sql].squeeze(' ')\n      location = fetch_call_site\n\n      if payload[:binds].any?\n        binds = "  " + payload[:binds].map { |col, val| [col.name, val] }.inspect\n        name = "#{name}  #{binds}"\n      end\n\n      debug "  #{name}  #{sql} - (#{location})"\n    end\n\n    private\n\n    def fetch_call_site\n      caller.find do |call|\n        next if call.include?('/gems/')\n        next if call.include?('active_record')\n        next if call.include?('active_support')\n        next if call.include?('logger')\n\n        return call\n      end\n    end\n  end\nend