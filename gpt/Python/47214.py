from collections import defaultdict\n\ndef clients_list(request):\n    clients = Client.objects.filter(status__in=['current', 'acquired', 'past']).order_by('status')[:30]\n    \n    clients_dict = defaultdict(list)\n    for client in clients:\n        clients_dict[client.status].append(client)\n    \n    current_clients = clients_dict['current'][:10]\n    acquired_clients = clients_dict['acquired'][:10]\n    past_clients = clients_dict['past'][:10]\n\n    return render(request, 'clients/list.html', {\n        'current_clients': current_clients,\n        'acquired_clients': acquired_clients,\n        'past_clients': past_clients\n    })