class SyncManager\n\n  # Generate UUID for new records\n  def generate_uuid\n    SecureRandom.uuid\n  end\n\n  # Push changes from client to server and vice versa\n  def sync_changes(last_synced_timestamp)\n    # Fetch changed entries since the last synced timestamp\n    local_changes = fetch_local_changes_since(last_synced_timestamp)\n\n    # Send these changes to the server and receive other clients' changes\n    combined_changes = push_and_receive_changes(local_changes, last_synced_timestamp)\n\n    # Apply received changes locally, ensuring no duplicates\n    apply_changes(combined_changes)\n  end\n\n  private\n\n  def fetch_local_changes_since(timestamp)\n    ChangeLog.where("changed_at >= ?", timestamp).where.not(operation: 'delete').map(&:entry_uuid) +\n      ChangeLog.where("changed_at >= ?", timestamp).where(operation: 'delete').pluck(:entry_uuid)\n  end\n\n  def push_and_receive_changes(local_changes, last_synced_timestamp)\n    # Send changes to the server and get changes from other clients\n    response = HTTP.post(SYNC_URL, json: {changes: local_changes, since: last_synced_timestamp})\n    JSON.parse(response.body)['changes']\n  rescue StandardError => e\n    puts "Sync error: #{e.message}"\n    []\n  end\n\n  def apply_changes(changes)\n    # Apply received changes (inserts/deletes) ensuring no duplicates\n    changes.each do |change|\n      if change['operation'] == 'delete'\n        delete_entry(change['entry_uuid'])\n      else\n        insert_or_update_entry(change['data']) unless entry_exists?(change['entry_uuid'])\n      end\n    end\n\n    # Update the last sync timestamp or transaction ID here\n  end\n\nend