# mutation analysis

# original method
def filterData(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index < len(data):
        item = data[index]
        if item in exceptions:
            modified_item = str(item) + '_EXCEPTION'
        elif item > limit:
            modified_item = item * 2
        else:
            modified_item = item / limit
        filtered_data.append(modified_item)
        index += 1
    return filtered_data

# mutation 1
def filterData1(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index < len(data):
        item = data[index]
        if item in exceptions:
            modified_item = str(item) + '_EXCEPTION'
        elif item == limit:
            modified_item = item * 2
        else:
            modified_item = item / limit
        filtered_data.append(modified_item)
        index += 1
    return filtered_data

# mutation 2
def filterData2(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index < len(data):
        item = data[index]
        if item in exceptions:
            modified_item = str(item) + '_EXCEPTION'
        elif item < limit:
            modified_item = item * 2
        else:
            modified_item = item / limit
        filtered_data.append(modified_item)
        index += 1
    return filtered_data

# mutation 3
def filterData3(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index < len(data):
        item = data[index]
        if item in exceptions:
            modified_item = str(item) + '_EXCEPTION'
        elif item > limit:
            modified_item = item * 5
        else:
            modified_item = item / limit
        filtered_data.append(modified_item)
        index += 1
    return filtered_data

# mutation 4
def filterData4(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index < len(data):
        item = data[index]
        if item in exceptions:
            modified_item = str(item) + '_EXCEPTION'
        elif item > limit:
            modified_item = item * 2
        else:
            modified_item = item / (limit^2)
        filtered_data.append(modified_item)
        index += 1
    return filtered_data

# mutation 5
def filterData5(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index < len(data):
        item = data[index]
        if item in exceptions:
            modified_item = str(item) + '_EXCEPTION'
        elif item > limit:
            modified_item = item * limit
        else:
            modified_item = item / 2
        filtered_data.append(modified_item)
        index += 1
    return filtered_data

# mutation 6
def filterData6(data, limit, exceptions):
    filtered_data = []
    index = 0
    while index < len(data):
        item = data[index]
        if (item in exceptions) == False:
            modified_item = str(item) + '_EXCEPTION'
        elif item > limit:
            modified_item = item * 2
        else:
            modified_item = item / limit
        filtered_data.append(modified_item)
        index += 1
    return filtered_data

# test cases
data = [[1],[1,2],[3,6],[3,7,16]]
limits = [5,5,4,8]
exceptions = [[1,2],[1,3],[0],[5,6,7]]

# runs the test cases with original and mutated code, prints results
for i in range(len(limits)):
    print('\nPass',i)
    print('1:',filterData1(data[i], limits[i], exceptions[i]))
    print('2:',filterData2(data[i], limits[i], exceptions[i]))
    print('3:',filterData3(data[i], limits[i], exceptions[i]))
    print('4:',filterData4(data[i], limits[i], exceptions[i]))
    print('5:',filterData5(data[i], limits[i], exceptions[i]))
    print('6:',filterData6(data[i], limits[i], exceptions[i]))
    print("\nOriginal:")
    print(filterData(data[i], limits[i], exceptions[i]))
