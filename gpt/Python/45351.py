import consul\n\n   def register_service():\n       c = consul.Consul()\n       c.agent.service.register('my-app', service_id='my-app-1', address='192.168.1.100', port=5000)\n\n   def discover_services():\n       c = consul.Consul()\n       services = c.agent.services()\n       for service in services.values():\n           print(f"Service ID: {service['ID']}, Address: {service['Address']}, Port: {service['Port']}")\n\n   if __name__ == "__main__":\n       register_service()\n       discover_services()