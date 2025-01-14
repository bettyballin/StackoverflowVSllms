struct my_data {
    int x;
};

typedef struct {
    struct my_data data[5];
    int head;
    int tail;
} my_queue_t;

volatile my_queue_t queue;

int main() {
    while (queue.head == queue.tail);
}