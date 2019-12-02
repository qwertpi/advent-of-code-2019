def fuel_calc(mass)
    #string to int
    mass = mass.to_i
    #divison between ints is floor by deafult
    fuel = mass / 3
    fuel -= 2
    return fuel
end

total_fuel = 0
for line in File.open("input.txt", "r").each_line do
    new_fuel = fuel_calc(line)
    while new_fuel > 0
        total_fuel += new_fuel
        new_fuel = fuel_calc(new_fuel)
    end
#closes file
end
#outputs answer
puts(total_fuel)
