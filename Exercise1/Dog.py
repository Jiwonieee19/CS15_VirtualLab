class Dog:
    def __init__(self, name, age):
        self.__n = name
        self.__a = age

    def bark(self):
        print("Woof! Woof!")

    def celebrate_birthday(self):
        self.__a += 1
        print(f"Happy Birthday! {self.__n} is now {self.__a} years old")

    def get_info(self):
        res = f"Dog Name: {self.__n}, Age: {self.__a}"
        return res


d = Dog("Yosh", 5)
d.bark()
d.celebrate_birthday()
print(d.get_info())