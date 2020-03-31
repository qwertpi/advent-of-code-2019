import io.Source.fromFile
import math.abs
import scala.collection.mutable

// extracts the single line of intcode and stores it as an array
// each intcode memory location is given it's own element
val file = fromFile("input.txt").getLines
val wire_1 = file.next().split(",")
val wire_2 = file.next().split(",")

var wire_1_points: mutable.Set[(Int, Int)] = mutable.Set()
var wire_2_points: mutable.Set[(Int, Int)] = mutable.Set()

var x: Int = 0
var y: Int = 0
var i: Int = 0
var direction: Char = '.'
var length: Int = 0

//prdouces an exahustive list for each wire of every point that the wire crosses through
for (command <- wire_1){
    direction = command(0)
    length = command.slice(1,100).toInt
    if (direction == 'R') {
        for (i <- (1 to length)){
            x += 1
            wire_1_points.add((x,y))
        }
    }
    else if (direction == 'L') {
        for (i <- (1 to length)){
            x -= 1
            wire_1_points.add((x,y))
        }
    }
    else if (direction == 'U') {
        for (i <- (1 to length)){
            y += 1
            wire_1_points.add((x,y))
        }
    }
    else if (direction == 'D') {
        for (i <- (1 to length)){
            y -= 1
            wire_1_points.add((x,y))
        }
    }
}

x = 0
y = 0
for (command <- wire_2){
    direction = command(0)
    length = command.slice(1,100).toInt
    if (direction == 'R') {
        for (i <- (1 to length)){
            x += 1
            wire_2_points.add((x,y))
        }
    }
    else if (direction == 'L') {
        for (i <- (1 to length)){
            x -= 1
            wire_2_points.add((x,y))
        }
    }
    else if (direction == 'U') {
        for (i <- (1 to length)){
            y += 1
            wire_2_points.add((x,y))
        }
    }
    else if (direction == 'D') {
        for (i <- (1 to length)){
            y -= 1
            wire_2_points.add((x,y))
        }
    }
}
//intersection of the two sets
val common_points = wire_1_points & wire_2_points

var best_point: (Int, Int) = (0,0)
//very high just to be on the safe side
var best_point_distance: Int = 2000000000
var distance: Int = 0
for (point <- common_points) {
    //._1 gets the first element in a tuple
    //._2 gets the second element in a tuple
    distance = abs(point._1) + abs(point._2)
    if (distance < best_point_distance) {
        best_point = point
        best_point_distance = distance
    }
}
println(best_point)
println(best_point_distance)