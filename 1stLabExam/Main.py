from Student import Student
        
class Main:
    print("===== STUDENT GRADING SYSTEM =====")
    name = input("Enter your FULL NAME: ")

    while(True):
        try:
            ID = int (input("Enter your STUDENT ID NUMBER: "))
        except:
            print("ENTER VALID NUMBER/S!!")
            continue
        break
    
    Studs = Student(name, ID)
    listOfGrade = Studs.add_grades() # store the array/list that is returned
    totalAve = Studs.calculate_average(listOfGrade) # store float
    Studs.display_info(listOfGrade, totalAve) # diplay, this is a void method
    res = Studs.get_grade_letter(totalAve) # store letter grade in res
    print(res + "\n")