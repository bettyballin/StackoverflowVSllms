include Rails.application.routes.url_helpers\nentries_url # => "http://localhost:3000/entries"\nnew_entry_url # => "http://localhost:3000/entries/new"\nentry_path(1) # => "/entries/1"