import math.floor
import io.Source.fromFile

object b extends App {
	def fuel_calc(mass: Int): Int ={
    return floor(mass/3).toInt - 2
	}

	var total_fuel : Int = 0
	for (line <- fromFile("input.txt").getLines){
	    var new_fuel: Int = fuel_calc(line.toInt)
	    while (new_fuel >= 0) {
	        total_fuel += new_fuel
	        new_fuel = fuel_calc(new_fuel)
	    }
	}
	println(total_fuel)
}