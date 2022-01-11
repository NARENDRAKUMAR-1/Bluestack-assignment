
import re

def print_the_statement(): #our function

    find1 = "beginning of assignment"
    file = open('Assignment2/start_assignment.log', 'r', encoding="utf8")
    log_lines = file.read().split('\n') # split based on the new line
    file.close()


    start1 = 0
    for line, strr in enumerate(log_lines):
        if strr.find(find1) != -1:
            start1 = line-1
            # print(start1)
            break

    search_space1 = log_lines[start1 +1:]

    # find2 = "required_pattern_"

    required_pattern_file=""
    for line, strr in enumerate(search_space1):
        # if strr.find(find2) != -1:
        match = re.search(r'required_pattern_[0-9]{2}', strr)  # by using the Regex as suggested in doc
        if match:
            start2 = line-1
            # print(start2)
            # required_pattern_file = strr[ strr.find(find2) :  ]

            required_pattern_file = strr[ match.start() :  ]
            break

    # print("required_pattern_file",  required_pattern_file)


    find3 = "assignment_completed"
    try:
        search_space = open("Assignment2/Logs/"+ required_pattern_file, "r", encoding= 'utf-8' )
        log_lines2 = search_space.read().split('\n') # split based on the new line
        search_space.close()

        start3 = 0
        for line, strr in enumerate(log_lines2):
            if strr.find(find3) != -1:
                start3 = line-1
                # print(start3)
                break

        final_meassage = log_lines2[start3+2]
        print(" final_meassage ", final_meassage)


    except:
        print(" Sorry, Maybe the file pattern you searched doesn't exist")


print_the_statement()
