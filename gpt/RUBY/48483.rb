# app/models/observers/action_observer.rb\n    class ActionObserver < ActiveRecord::Observer\n      def after_update(record)\n        log_action(record, 'update')\n      end\n\n      def after_create(record)\n        log_action(record, 'create')\n      end\n\n      private\n\n      def log_action(record, action)\n        user = Current.user\n        # Assuming you have a Log model to store logs\n        Log.create(user: user, action: action, record: record)\n      end\n    end