def fuel_calc(mass)
    #string to int
    mass = mass.to_i
    #divison between ints is floor by deafult
    fuel = mass / 3
    fuel -= 2
    return fuel
end

total_fuel = 0
File.open("input.txt", "r").each_line do |line|
    total_fuel += fuel_calc(line)
#closes file
end

#outputs answer
puts(total_fuel)
