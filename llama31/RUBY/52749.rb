# config/application.rb\nmodule YourApp\n  class Application < Rails::Application\n    # ...\n\n    # Configure ActionCable\n    config.action_cable.url = 'ws://localhost:28080'\n  end\nend\n\n# app/channels/events_channel.rb\nclass EventsChannel < ApplicationCable::Channel\n  def subscribed\n    stream_from 'events'\n  end\n\n  def unsubscribed\n    # Any cleanup needed when channel is unsubscribed\n  end\nend\n\n# app/controllers/events_controller.rb\nclass EventsController < ApplicationController\n  def create\n    # Store event data in database\n    Event.create!(params[:event])\n\n    # Broadcast the event to connected clients\n    EventsChannel.broadcast_to('events', params[:event])\n  end\nend