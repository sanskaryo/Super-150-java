# To calculate geometric promgression 

a = int(input("Enter the first "))

b = int(input("Enter the common ratio  "))

n = int(input("Enter the number of terms "))

def geometric_progression(a, b, n):
  
    
    return a * b ** (n-1)
    
print(geometric_progression(a, b, n))


