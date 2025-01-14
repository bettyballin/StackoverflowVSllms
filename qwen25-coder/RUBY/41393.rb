require 'net/manager'\n\nclass AsteriskMonitor\n  def initialize(username, password)\n    @client = AMI::Client.new(host: 'localhost', username: username, secret: password)\n  end\n\n  def start_listening\n    @client.on(:newchannel, method(:handle_new_channel))\n    @client.connect\n  end\n\n  private\n\n  def handle_new_channel(event)\n    event_data = {\n      remote_extension: event['CallerIDNum'],\n      local_extension: event['Exten'],\n      call_direction: event['ChannelStateDesc'],\n      channel_status: event['ChannelStateDesc'],\n      start_time: Time.now.utc\n    }\n\n    # Use HTTP or Sidekiq to push data to Rails App\n    if defined?(Sidekiq)\n      ProcessAsteriskEventJob.perform_async(event_data)\n    else\n      Faraday.post("http://localhost/events", event_data.to_json, headers: { 'Content-Type': 'application/json' })\n    end\n  end\nend\n\n# Start monitoring\nmonitor = AsteriskMonitor.new('admin', 'somepassword')\nmonitor.start_listening