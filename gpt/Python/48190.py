import pytest\nimport requests\n\ndef test_api_integration():\n    response = requests.get('https://api.example.com/data')\n    assert response.status_code == 200\n    assert 'expected_key' in response.json()\n\nif __name__ == '__main__':\n    pytest.main()