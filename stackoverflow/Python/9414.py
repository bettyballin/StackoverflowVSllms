clients = Client.objects.filter(Q(status='current')|Q(status='acquired')|Q(status='past'))[:30]