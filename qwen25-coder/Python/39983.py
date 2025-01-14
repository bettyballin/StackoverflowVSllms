def calculate_amportization_schedule(principal, annual_interest_rate, total_days):\n    daily_interest_rate = (annual_interest_rate / 100) / 365\n    \n    # Calculate the total payment using annuity formula for daily payments over total_days\n    # P = [r*PV] / [1 - (1 + r)^-n]\n    r = daily_interest_rate\n    n = total_days\n    PV = principal\n    total_payment = (r * PV) / (1 - (1 + r) ** -n)\n    \n    balance = principal\n    schedule = []\n    \n    for day in range(1, total_days + 1):\n        interest_payment = round(balance * daily_interest_rate, 2)\n        principal_payment = round(total_payment - interest_payment, 2)\n        balance -= principal_payment\n        \n        # Add this payment period to the schedule\n        schedule.append({\n            'Day': day,\n            'Total Payment': total_payment,\n            'Interest Payment': interest_payment,\n            'Principal Payment': principal_payment,\n            'Balance': max(0.0, balance)  # Ensure balance doesn't go negative due to rounding errors\n        })\n    \n    return schedule\n\n# Example usage:\nschedule = calculate_amportization_schedule(principal=10000, annual_interest_rate=5, total_days=365)\nfor entry in schedule[:10]:  # Print the first 10 days for brevity\n    print(entry)