// This code snippet does not demonstrate the full setup but illustrates a part of it using Ratchet (a WebSocket library for PHP)\n\nuse Ratchet\MessageComponentInterface;\nuse Ratchet\ConnectionInterface;\n\nrequire __DIR__ . '/vendor/autoload.php';\n\nclass Chat implements MessageComponentInterface {\n    protected $clients;\n\n    public function __construct() {\n        $this->clients = new \SplObjectStorage;\n    }\n\n    public function onOpen(ConnectionInterface $conn) {\n        // Store the new connection to send messages to later\n        $this->clients->attach($conn);\n        echo "New connection! ({$conn->resourceId})\n";\n    }\n\n    public function onMessage(ConnectionInterface $from, $msg) {\n        foreach ($this->clients as $client) {\n            if ($from !== $client) {\n                // The sender is not the receiver, send to each client connected\n                $client->send($msg);\n            }\n        }\n    }\n\n    public function onClose(ConnectionInterface $conn) {\n        // The connection is closed, remove it, as we can no longer send it messages\n        $this->clients->detach($conn);\n\n        echo "Connection {$conn->resourceId} has disconnected\n";\n    }\n\n    public function onError(ConnectionInterface $conn, \Exception $e) {\n        echo "An error has occurred: {$e->getMessage()}\n";\n\n        $conn->close();\n    }\n}\n\n$server = \Ratchet\WebSockets\WsServer::decorate(\n    new Chat()\n);\n\n$app = new \Ratchet\App('localhost', 8080);\n$app->route('/chat', $server, ['*']);\n$app->run();