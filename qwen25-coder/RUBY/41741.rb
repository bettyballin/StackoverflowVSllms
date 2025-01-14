class GameSessionChannel < ApplicationCable::Channel\n  def subscribed\n    @room = 'game_room' # or use some unique identifier for the game session\n    stream_from @room\n\n    # Add client to the room tracker (ideally use Redis for production)\n    $redis.sadd(@room, current_user.id) if current_user.present?\n  end\n\n  def unsubscribed\n    # Remove client from the room tracker on disconnect\n    $redis.srem(@room, current_user.id) if current_user.present?\n  end\n\n  def pair_clients\n    clients = $redis.smembers(room)\n    if clients.size >= 2\n      ActionCable.server.broadcast @room, 'paired'\n      # Remove these users from the room or handle pairing logic here\n    end\n  end\n\n  private\n\n  attr_reader :room\nend