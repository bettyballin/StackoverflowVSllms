Public Class UserListViewModel\n\n  Private _clientService As IPortalClientService\n\n  Public Sub New(ByVal users As MembershipUserCollection, ByVal selectedClient As Integer, ByVal clientService As IPortalClientService)\n    _users = users\n    _clientService = clientService\n    _clients = New SelectList(_clientService.GetClients.OrderBy(Function(c) c.ClientName), "ID", "ClientName", selectedClient)\n  End Sub\n\n  ' ... rest of the class remains the same ...