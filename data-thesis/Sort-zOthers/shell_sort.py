import sort_tools
import copy

def shell_sort(data, n):
        gap = n // 2

        while gap > 0:
            for i in range(gap, n):
                temp = data[i]; # create hole

                #slide greater elements down
                j = i
                while j > 0 and data[j-gap] > temp:
                    data[j] = data[j-gap]
                    j -= gap
                
                data[j] = temp
                
            gap = gap // 2

@sort_tools.timeit('shell')
def sort(data):
    shell_sort(data, len(data))

def main():
    data = sort_tools.build_data_set(5)

    unsorted = copy.deepcopy(data)
    sort(unsorted)

if __name__ == "__main__":
    main()