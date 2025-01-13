class Node:\n    def __init__(self, value):\n        self.value = value\n        self.next = None\n\ndef reverse_list(head):\n    prev = None\n    current = head\n    while current:\n        next_node = current.next\n        current.next = prev\n        prev = current\n        current = next_node\n    return prev\n\ndef print_list(head):\n    current = head\n    while current:\n        print(current.value, end=" ")\n        current = current.next\n    print()\n\ndef print_list_backwards(head):\n    # First pass: reverse the linked list\n    reversed_head = reverse_list(head)\n    \n    # Print the reversed list\n    print_list(reversed_head)\n    \n    # Second pass: reverse the list again to restore original order\n    reverse_list(reversed_head)\n\n# Example usage:\nhead = Node(1)\nhead.next = Node(2)\nhead.next.next = Node(3)\nhead.next.next.next = Node(4)\n\nprint_list_backwards(head)