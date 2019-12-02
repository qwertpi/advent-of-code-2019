def opcode_calc(opcode, inp_1, inp_2)
    if opcode == 1
        return inp_1 + inp_2
    end
    if opcode == 2
        return inp_1 * inp_2
    end
    raise "Unkown opcode"+opcode
end

#(a..b) is equivalent to python's range(a,b) but b is inclusive
#use ... to make b exclusive
for a in (0..100)
    for b in (0..100)
        data = File.open("input.txt", "r").read.split(",")
        i = 0

        data[1] = a
        data[2] = b

        while i <= data.length
            opcode = data[i].to_i
            inp_1 = data[data[i+1].to_i].to_i
            inp_2 = data[data[i+2].to_i].to_i
            output = data[i+3].to_i
            if opcode == 99
                if data[0] == 19690720 
                    puts(a)
                    puts(b)
                    puts(100 * a + b)
                    exit!(0)
                else
                    break
                end
            else
                data[output.to_i] = opcode_calc(opcode, inp_1, inp_2)
            end
            i += 4
        end
    end
end
