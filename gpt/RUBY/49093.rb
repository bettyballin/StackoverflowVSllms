duplicate_locations = Location.select('id, url, lat, lng, MIN(created_at) as oldest')\n                              .group(:lat, :lng)\n                              .having('COUNT(*) > 1')\n\nduplicate_locations.each do |duplicate|\n  locations = Location.where(lat: duplicate.lat, lng: duplicate.lng)\n  \n  if locations.any? { |loc| loc.url.present? }\n    location_to_keep = locations.find { |loc| loc.url.present? }\n  else\n    location_to_keep = locations.min_by(&:created_at)\n  end\n\n  locations.each do |location|\n    location.destroy unless location == location_to_keep\n  end\nend