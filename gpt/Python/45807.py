import pika, json\n    from PIL import Image\n\n    def resize_image(image_path, sizes):\n        img = Image.open(image_path)\n        for size in sizes:\n            img_resized = img.resize(size, Image.ANTIALIAS)\n            img_resized.save(f"{image_path}_{size[0]}x{size[1]}.jpg")\n\n    def callback(ch, method, properties, body):\n        data = json.loads(body)\n        image_path = data['image_path']\n        sizes = data['sizes']\n        resize_image(image_path, sizes)\n        ch.basic_ack(delivery_tag=method.delivery_tag)\n\n    connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))\n    channel = connection.channel()\n\n    channel.queue_declare(queue='image_resize_queue', durable=True)\n    channel.basic_qos(prefetch_count=1)\n    channel.basic_consume(queue='image_resize_queue', on_message_callback=callback)\n\n    print('Waiting for messages. To exit press CTRL+C')\n    channel.start_consuming()