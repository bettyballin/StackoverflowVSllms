# App 1 (data source)\nclass MyModel < ApplicationRecord\n  after_save do\n    # Send a message to the queue\n    RabbitMQ.publish('my_model_updated', self.to_json)\n  end\nend\n\n# App 2 (data consumer)\nclass MyModelSyncJob < ActiveJob::Base\n  def perform\n    # Consume the message from the queue\n    message = RabbitMQ.consume('my_model_updated')\n    my_model = JSON.parse(message)\n    # Update or create the model in App 2\n  end\nend