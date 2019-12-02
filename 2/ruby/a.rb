data = File.open("input.txt", "r").read.split(",")
i = 0

def opcode_calc(opcode, inp_1, inp_2)
    if opcode == 1
        return inp_1 + inp_2
    end
    if opcode == 2
        return inp_1 * inp_2
    end
    raise "Unkown opcode"+opcode
end

while i <= data.length
    opcode = data[i].to_i
    inp_1 = data[data[i+1].to_i].to_i
    inp_2 = data[data[i+2].to_i].to_i
    output = data[i+3].to_i
    if opcode == 99
        puts("End")
        p(data)
        puts(data[0])
        break
    else
        data[output.to_i] = opcode_calc(opcode, inp_1, inp_2)
    end
    i += 4
end
