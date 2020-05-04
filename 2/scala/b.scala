import io.Source.fromFile

object b extends App {
    // extracts the single line of intcode and stores it as an array
    // each intcode memory location is given it's own element
    var program = fromFile("input.txt").getLines.next().split(",")

    //used to store the address of the operand
    var operand_pos : Int = 0
    //can be any value other than 99
    var operand: Byte = 0

    //used to store the address of the first input passed to the operand
    var input_1_loc: Int = 0
    ////used to store the address of the first input passed to the operand
    var input_2_loc: Int = 0
    //used to store the value in input_1_loc
    var input_1: Int = 0
    // //used to store the value in input_2_loc
    var input_2: Int = 0

    //used to store the location where the output should be saved to
    var output_loc: Int = 0
    // used to store the value of the calculation
    var result: Int = 0

    /* this copy is operated upon
    so that the original state of the intcode memory can restored
    every time the value of noun or verb changes */
    var program_copy = program.clone()
    for (noun <- 1 to 99){
        for (verb <- 1 to 99){
            //restoring the original state of the intcode memory
            program_copy = program.clone()
            //subbing in the values of noun and verb
            program_copy(1) = noun.toString
            program_copy(2) = verb.toString
            
            //reseting varibales that won't reset themselves in time (most of them reset before any computation is done on them)
            operand = 0
            operand_pos = 0
            while (operand != 99) {
                // extracts addresses of inputs and outputs
                input_1_loc = program_copy(operand_pos + 1).toInt
                input_2_loc = program_copy(operand_pos + 2).toInt
                output_loc = program_copy(operand_pos + 3).toInt
                
                //gets data from memory adresses
                operand = program_copy(operand_pos).toByte
                input_1 = program_copy(input_1_loc).toInt
                input_2 = program_copy(input_2_loc).toInt
                
                if (operand == 1) {
                    result = input_1 + input_2
                }
                else if (operand == 2){
                    result = input_1 * input_2
                }
            
                //stores the result in the output location passed to the operand
                program_copy(output_loc) = result.toString
                // jumps to the next operand
                operand_pos += 4
                if (program_copy(0).toInt == 19690720) {
                    println(noun)
                    println(verb)
                    println((100*noun)+verb)
                    System.exit(0)
                }
            
            }
        }
    }
}