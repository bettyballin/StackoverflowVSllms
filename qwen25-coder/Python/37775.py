class Peer:\n    def __init__(self, peer_id):\n        self.peer_id = peer_id\n        self.connections = []\n\n    def join_game(self, peer_network):\n        # Connect to the peer network\n        peer_network.add_peer(self)\n        print(f"{self.peer_id} has joined the game.")\n\n    def leave_game(self, peer_network):\n        # Disconnect from the peer network\n        peer_network.remove_peer(self)\n        print(f"{self.peer_id} has left the game.")\n\nclass PeerNetwork:\n    def __init__(self):\n        self.peers = []\n\n    def add_peer(self, peer):\n        if peer not in self.peers:\n            self.peers.append(peer)\n            # Notify other peers of new connection\n            for p in self.peers:\n                print(f"Notifying {p.peer_id} that {peer.peer_id} joined.")\n\n    def remove_peer(self, peer):\n        if peer in self.peers:\n            self.peers.remove(peer)\n            # Notify other peers of disconnection\n            for p in self.peers:\n                print(f"Notifying {p.peer_id} that {peer.peer_id} left.")\n\n# Example usage\nnetwork = PeerNetwork()\nalice = Peer("Alice")\nbob = Peer("Bob")\n\nalice.join_game(network)\nbob.join_game(network)\n\nalice.leave_game(network)