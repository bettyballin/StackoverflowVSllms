def log_visit\n  @visit = Visit.new(url: request.referer)\n  @visit.save\nend