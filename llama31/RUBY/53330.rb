def set_status\n  if status.blank?\n    if (consulted_legal == true) && (consulted_marketing == true)\n      self.status = "Pending Approval"\n    elsif (consulted_legal == true) && (consulted_marketing == false)\n      self.status = "Awaiting Marketing Approval"\n    elsif (consulted_legal == false) && (consulted_marketing == true)\n      self.status = "Awaiting Legal Approval"\n    elsif (consulted_legal == false) && (consulted_marketing == false)\n      self.status = "Awaiting Marketing & Legal Approval"\n    end\n  end\n  true # Needs to return true for the update to go through\nend