$is_approved = 0; // Default to not approved for unregistered users\n\n$query = "INSERT INTO posts (content, ip_address, is_approved) VALUES ('$post_content', '$ip_address', '$is_approved')";\nmysqli_query($conn, $query);