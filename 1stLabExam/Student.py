
class Student:
    def __init__(self, name, ID):
        self.name = name
        self.ID = ID

    # recording 3 subject grades then returened as array/list 
    def add_grades(self):

        # restart if lapas 100 or not number
        while(True):
            try:
                progLang = int(input("Enter your PROGRAMMING LANGUAGE Grade [Grade/100]: "))
                if (progLang > 100):
                    print("GRADE CANNOT BE EXCEEDED ON 100!")
                    continue
            except:
                print("ENTER VALID NUMBER/S!!")
                continue
            break

        # restart directly asa nga grade nag error, if e isa ug loop, mobalik sa 1st even though sa 2nd/3rd na namali/error input
        while(True):
            try:
                webDev = int(input("Enter your WEB DEVELOPMENT Grade [Grade/100]: "))
                if (webDev > 100):
                    print("GRADE CANNOT BE EXCEEDED ON 100!")
                    continue
            except:
                print("ENTER VALID NUMBER/S!!")
                continue
            break

        # same reason
        while(True):
            try:
                database = int(input("Enter your DATABASE Grade [Grade/100]: "))
                if (database > 100):
                    print("GRADE CANNOT BE EXCEEDED ON 100!")
                    continue
            except:
                print("ENTER VALID NUMBER/S!!")
                continue
            break
        listOfGrade = [progLang, webDev, database]
        return listOfGrade

    
    # calculates the average then return float 
    def calculate_average(self, listOfGrade):
        total = 0
        for grade in listOfGrade:
            grade = float(grade)
            total += grade
        totalAve = total / 3
        return totalAve
    

    # display info returns nothing
    def display_info(self, listOfGrade, totalAve):
        print("\n===== STUDENTS' INFORMATION =====")
        print(f"NAME: {self.name}")
        print(f"ID NUMBER: {self.ID}")
        print(f"\nPROGRAMMING LANGUAGE GRADE: {listOfGrade[0]}")
        print(f"WEB DEVELOPMENT GRADE: {listOfGrade[1]}")
        print(f"DATABASE GRADE: {listOfGrade[2]}")
        print(f"GWA: {totalAve:.2f}\n")


    # get the letter as string
    def get_grade_letter(self, totalAve):
        if (totalAve > 95): res = "CONGRATULATIONS ON ACHIEVING HIGH REMARKS :>"
        elif (totalAve > 90): res = "CONGRATS ON ACCOMPLISHING GREAT REMARKS :)"
        elif (totalAve > 80): res ="GRATS ON YOUR GOOD REMARKS"
        elif (totalAve > 75): res ="UHHM, TRY HARDER!"
        else: res = "SANAOL RETAKE!"
        return res

