def fuel_calc(mass):
    mass = int(mass)

    #floor division
    fuel = mass // 3
    fuel -= 2

    return fuel

total_fuel = 0

with open("input.txt", "r") as f:
    data = f.read().splitlines()

for mass in data:
    total_fuel += fuel_calc(mass)
    
print(total_fuel)
