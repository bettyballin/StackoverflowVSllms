from django.db.models import Q\n\naccountDetails = {\n    'username': request.user.username,\n    'hostname': [],\n    'distro': [],\n    'location': [],\n}\n\nsubscriptions = xenpanel_subscription.objects.select_related('node').filter(customer_id=request.user.id)\nfor subscription in subscriptions:\n    accountDetails['hostname'].append(subscription.hostname)\n    accountDetails['distro'].append(subscription.distro)\n    accountDetails['location'].append(subscription.node.location)\n\nreturn render_to_response('account.html', accountDetails, context_instance=RequestContext(request))