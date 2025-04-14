def solve_bobritto_problem(n_days, m_day, left, right):
    # We can choose any left' where left ≤ left' ≤ right-m
    # For simplicity, we'll take the leftmost valid segment
    left_prime = left
    right_prime = left + m_day
    
    return left_prime, right_prime

def main():
    try:
        # Read number of test cases
        t = int(input().strip())
        
        for _ in range(t):
            # Read each test case line
            line = input().strip()
            if not line:  # Skip empty lines
                continue
                
            n_days, m_day, left, right = map(int, line.split())
            left_prime, right_prime = solve_bobritto_problem(n_days, m_day, left, right)
            print(left_prime, right_prime)
            
    except EOFError:
        pass  # Handle end of input gracefully
    except ValueError as e:
        print(f"Input error: {e}")

if __name__ == "__main__":
    main()