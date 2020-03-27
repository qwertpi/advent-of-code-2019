import math.floor
import io.Source.fromFile

def fuel_calc(mass: Int): Int ={
    return floor(mass/3).toInt - 2
}

var total_fuel: Int = 0
for (line <- fromFile("input.txt").getLines){
    total_fuel += fuel_calc(line.toInt)
}
println(total_fuel)
