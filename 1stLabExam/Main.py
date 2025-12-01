

class Student:
    def __init__(self, name, ID):
        self.name = name
        self.ID = ID

    def add_grades(self):
        progLang = input("Enter your PROGRAMMING LANGUAGE Grade [Grade/100]: ")
        print(f"dfd{progLang}")
        webDev = input("Enter your WEB DEVELOPMENT Grade [Grade/100]: ")
        print(f"dfd{webDev}")
        database = input("Enter your DATABASE Grade [Grade/100]: ")
        print(f"dfd{database}")
        print()
        




class Main:
    print("===== STUDENT GRADING SYSTEM =====")
    name = input("Enter your FULL NAME: ")
    print(f"dfd{name}")
    ID = input("Enter your STUDENT ID NUMBER: ")
    print(f"dfd{ID}")
    
    Studs = Student(name, ID)
    Studs.add_grades()