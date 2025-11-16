
itemNames = []
itemPrices = {}

def itemList():
    return print(f"{itemNames}\n{itemPrices}")

def addItem():
    while True:
        name = input("Enter item name: ")
        if name in itemNames:
            print("Cannot add duplicate/existing names!")
            continue

        while True:
            price = input("Enter price: ")
            try:
                price = float(price)
            except:
                print("Invalid price!")
                continue

            itemNames.append(name)
            itemPrices [name] = price
            return print("Item Added successfully!")
            # print(itemNames)
            # print(itemPrices)


def updatePrice():
    while True:
        update = input("Enter item name to update: ")
        if update not in itemNames:
            print("Item does not exist yet!")
            continue
        else:
            while True:
                newPrice = input("Enter new price: ")
                try:
                    newPrice = float(newPrice)
                except:
                    print("Invalid price!")
                    continue
                itemPrices [update] = newPrice
                return print("Price updated successfully!")


def start():
    while True:

        chc = input("\nChoice: ")
        try:
            chc = int(chc)
        except ValueError:
            print("Invalid, not a number!")
            continue

        match chc:
            case 1:
                itemList()
            case 2:
                addItem()
            case 3:
                updatePrice()
            case 4:
                print("Exiting ...")
                break
            case _:
                print("This choice does not exist!")
                continue

            
class Main:
    print("\n----- INVENTORY MENU ----- \n")
    print("[1] Item List\n[2] Add Item\n[3] Update Price\n[4] Exit")
    start()