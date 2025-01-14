import asyncio\nimport aiohttp\n\nasync def fetch(session, url):\n    async with session.get(url) as response:\n        return await response.text()\n\nasync def run(urls, num_requests_per_url=10):\n    async with aiohttp.ClientSession() as session:\n        tasks = []\n        for _ in range(num_requests_per_url):\n            for url in urls:\n                task = asyncio.create_task(fetch(session, url))\n                tasks.append(task)\n        await asyncio.gather(*tasks)\n\n# List of URLs to benchmark\nurls = ["http://remote-service-machine/api/endpoint1", "http://remote-service-machine/api/endpoint2"]\n\n# Run the benchmark\nasyncio.run(run(urls))