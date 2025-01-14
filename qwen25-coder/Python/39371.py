function serveResource(request):\n    varyHeader = getHeader(cacheEntry, 'Vary')\n    if varyHeader includes 'Accept-Encoding':\n        clientEncoding = request.headers['Accept-Encoding']\n        cachedRequestHeaders = cacheEntry.requestHeaders\n        if clientEncoding == cachedRequestHeaders['Accept-Encoding']:\n            return cacheEntry.resource\n        else:\n            # Fetch fresh resource from server\n            response = fetchResourceFromServer(request)\n            updateCache(request, response)\n            return response\n    else:\n        return cacheEntry.resource