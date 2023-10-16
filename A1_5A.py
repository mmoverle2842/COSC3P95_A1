# given method
def processString(input_str):
    output_str = ""
    for char in input_str:
        if char.isupper():
            output_str += char.lower()
        elif char.isnumeric():
            output_str += char * 2
        else:
            output_str += char.upper()
    return output_str

# strings used to test method
inStrings = ["ABc123deF", "oK;;69", "60 70 bYe ByE"]
for in_str in inStrings:
    print(f"In: {in_str}\nOut: {processString(in_str)}")
