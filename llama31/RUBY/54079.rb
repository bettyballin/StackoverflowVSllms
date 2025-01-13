@roles = Role.find_all_by_simulation_id(session[:sim_id])\n@messages = RolesMessages.find(:all, \n                              :conditions => ["sender_id IN (?) ", @roles.map(&:id)], \n                              :order => 'created_at DESC', \n                              :group => 'sender_id, message_id', \n                              :having => 'COUNT(*) = 1')