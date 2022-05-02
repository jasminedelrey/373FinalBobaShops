import random
import string
import pandas as pd
import re
# # random numbers for member's phone 
# for i in range(103):
#     print(random.randint(100000000,1000000000))

# # random strings for email
# letters = string.ascii_lowercase
# emailEnds = ['@gmail.com', '@yahoo.com', '@aol.com', '@bobalover.com', '@oxy.edu']
# for i in range(102):
#     print(''.join(random.choice(letters) for i in range(10)) + random.choice(emailEnds))

# # random home generated from website
# homes = pd.read_csv('addresses.csv')
# homes = homes["Address"]
# # print homes, gets rid of row value
# for i in range(len(homes)):
#     print(homes[i])

def createStoreCSV():
        # -------- Store ---------
    storeDF = pd.DataFrame(columns = ['store_id','name', 'rating', 'address', 'city'])
    bobaShopsDF = pd.read_csv('bayarea_boba_spots.csv')
    storeDF = storeDF.assign(store_id = bobaShopsDF['id'])
    storeDF = storeDF.assign(name = bobaShopsDF['name'])
    storeDF = storeDF.assign(rating = bobaShopsDF['rating'])
    storeDF = storeDF.assign(address = bobaShopsDF['address'])
    storeDF = storeDF.assign(city = bobaShopsDF['city'])


    # # create email - just append unique ID with email ending
    # emailEnds = ['@gmail.com', '@yahoo.com', '@aol.com', '@bobalover.com', '@oxy.edu']
    # storeEmail = []
    # for i in range(len(bobaShopsDF)):
    #     email = storeDF["store_id"][i] + random.choice(emailEnds)
    #     storeEmail.append(email)
    # storeDF = storeDF.assign(email = storeEmail)

    # create 2 CSVs, we will remove metadata from UpperCase one
    storeDF.to_csv('store.csv',index=False)
    storeDF.to_csv('373FinalBobaShops/Store.csv',index=False)
    return storeDF
storeDF = createStoreCSV()
def createEmpCSV():
    # -------- Employee ---------
    # Emp home_store_id
    numEmp = 30000-10000
    empDF = pd.DataFrame(columns = ['emp_id', 'address','email', 'Home_store_id', 'name', 'phone'])
    randNames = pd.read_csv('random_names.csv')
    empDF = empDF.assign(name = randNames)
    # generate phone numbers, not necessarily random
    phoneNum = []
    for i in range(len(empDF)):
        phoneNum.append(random.randint(1000000000,9999999999))
    empDF = empDF.assign(phone = phoneNum)

    # get list of unique stores, based on store_id
    storesList = storeDF
    homeStoreID = storesList.store_id.unique()

    # clean address data from csv, assign to emp DF 
    adrDF = pd.read_csv('addressesEmp.csv')
    adrDF['Address'] = adrDF['Address'].replace('"', "")
    empDF['address'] = adrDF['Address']
    empDF['address']= empDF['address'].replace(',', '', regex=True)
    idList = []
    storeIdList = []
    emailList = []
    for i in range(len(empDF)):
        # assign consecutive int for each ID
        idList.append(i+1)
        homeStore = random.choice(homeStoreID)
        storeIdList.append(homeStore)
        # use storeId as email domain and append to emp Name
        nameNoSpace = empDF.name[i].replace(" ", "")
        emailList.append(''.join(nameNoSpace) + "@" + homeStore + '.com')
    
    empDF['emp_id'] = idList
    empDF['Home_store_id'] = storeIdList
    empDF['email'] = emailList
    empDF.to_csv('employee.csv',index=False)
    empDF.to_csv('373FinalBobaShops/Employee.csv',index=False)
    print('Employee DF: \n' , empDF)
    return empDF 
empDF = createEmpCSV()
def createMemberCSV():
    # fix and create Member.csv
    oldMemberDF = pd.read_csv('oldMember.csv')
    memberDF = pd.DataFrame(columns = ['member_id', 'name', 'phone', 'email', 'address', 'year_init', 'month_init', 'day_init'])
    memberDF.name = oldMemberDF.Name


    idList = []
    emailList = []
    yearList = []
    monthList = []
    dateList = []
    # random DATE data type
    for i in range(len(memberDF)):

        # create id and emails  
        letters = string.ascii_lowercase
        id = ''.join(random.choice(letters) for i in range(10))
        # if id is in list, create new id 
        while (id in idList):
            id = ''.join(random.choice(letters) for i in range(10))
        idList.append(id)
        emailEnds = ['@gmail.com', '@yahoo.com', '@aol.com', '@bobalover.com', '@oxy.edu']
        email = ''.join(id) + random.choice(emailEnds)
        emailList.append(email)


        year = str(random.randint(2012, 2022))
        month = str(random.randint(1, 12))
        date = str(random.randint(1,30))
        if (year == 2022):
            month = str(random.randint(1, 4))
            date = str(random.randint(1,30))
        if (int(date) < 10):
            date = str('0') + str(date)
        if (int(month) < 10):
            month = str('0') + str(month)

        yearList.append(year)
        monthList.append(month)
        dateList.append(date)

    memberDF.member_id = idList
    memberDF.name = oldMemberDF.Name
    memberDF.phone = oldMemberDF.Phone
    memberDF.email = emailList
    memberDF['address']= oldMemberDF.Address.replace(',', '', regex=True)

    memberDF.year_init = yearList
    memberDF.month_init = monthList
    memberDF.day_init = dateList

    for i in range(10):
        memberDF['address'][i] = empDF['address'][i]
        memberDF['name'][i] = empDF['name'][i]
        memberDF['phone'][i] = empDF['phone'][i]
        memberDF['email'][i] = empDF['email'][i]

    memberDF.to_csv('member.csv',index=False)
    memberDF.to_csv('373FinalBobaShops/Member.csv',index=False)
    # print('Member DF \n', memberDF)
    return memberDF
memberDF = createMemberCSV()
print('done member')
def createBobaCSV():
    oldBobaDF = pd.read_csv('boba.csv')
    bobaDF = pd.DataFrame(columns = ['boba_id','name', 'price', 'review'])

    uniqueBoba = oldBobaDF.name.unique()
    bobaList = []
    # make duplicate uniqueBoba list 400 times
    for i in range(300):  bobaList.extend(uniqueBoba)
    bobaDF.name = bobaList

    # initialize empty lists
    costList = []
    idList = []
    emailList = []
    reviewList = []
    for i in range(len(bobaDF)):
        # create id
        id = i + 40000
        idList.append(id)
        cost = round(random.uniform(3.00, 8.00),2)
        review = round(random.uniform(2.00, 5.00),2)
        costList.append(cost)
        reviewList.append(review)

    bobaDF.boba_id = idList
    bobaDF.price = costList
    bobaDF.review = reviewList 
    bobaDF.to_csv('Boba.csv',index=False)

    bobaDF.to_csv('boba.csv',index=False)
    bobaDF.to_csv('373FinalBobaShops/Boba.csv',index=False)
    # print('Boba \n', len(bobaDF))
    return bobaDF
bobaDF = createBobaCSV()
print('done boba')
def createInventoryCSV():

    invDF = pd.DataFrame(columns = ['store_id', 'ingredient_id','quantity'])
    # ingredient_id is unique, randomly generated here
    # each store has 10 drinks, each drink must be represented here with at least a quantity of 1 
    storeList = []
    uniqueStoreList = storeDF.store_id.unique()
    bobaList = []
    quantityList = []
    # store_id will appear 50x
    for i in range(50):  storeList.extend(uniqueStoreList)
    del storeList[len(bobaDF):]
    invDF.store_id = storeList
    # assign random ingr_id for each store
    ingrList = []
    letters = string.ascii_lowercase
    for i in range(len(invDF)):
        # create random ingrID and emsure not already in list
        ingrId = random.randint(5000, 100000)
        while ingrId in ingrList:
            ingrId = random.randint(5000, 100000)
        ingrList.append(ingrId)
        quantity = random.randint(1,150)
        quantityList.append(quantity)
    invDF.quantity = quantityList
    invDF.ingredient_id = ingrList
    # print('Inventory: \n', invDF)
    invDF.to_csv('inventory.csv',index=False)
    invDF.to_csv('373FinalBobaShops/Inventory.csv',index=False)
    return invDF
invDF = createInventoryCSV()
print('done inv')
def createRecipeCSV():

    # pk is boba_id
    # here was assign a boba_id with a unique ingr_id( one:one relationship)
    
    bobaDF = pd.read_csv('boba.csv')
    recipeDF = pd.DataFrame(columns = ['store_id', 'ingredient_id', 'boba_id'])
    recipeDF.boba_id = bobaDF.boba_id
    ingrListOptions = invDF['ingredient_id'].tolist()

    # from inv, grab store and ingrId --> assign bobaDrink (other way arround)
    # get list of unique stores, based on store_id
    # storesList = createInventoryCSV()['store_id']
    storesList = invDF['store_id']
    ingrStoreList = []
    ingrIdList = []
    for i in range(len(recipeDF) ):
        # # assign ingredient, ensure not in list  
        # ingrId = random.choice(ingrListOptions)

        # # add to list and remove from options 
        # ingrIdList.append(ingrId)
        # ingrListOptions.remove(ingrId)

        # can assign a random store
        storeID = random.choice(storesList)
        ingrStoreList.append(storeID) 
        # #FIXMEEE: 
        #     # issue: store has multiple instances of ingredientID, need to iterate throguh all of them
        # ingrCount = invDF['ingredient_id'].value_counts().ingredient_id
        # storeId = invDF.loc[invDF['ingredient_id'] == ingrId, 'store_id']
        # for i in range(ingrCount):

        # print(invDF['ingredient_id'])
        # ingrStoreList.append(storeId.values[0])
    recipeDF['ingredient_id'] = ingrListOptions
    # recipeDF['ingredient_id'] = ingrIdList
    recipeDF['store_id'] = ingrStoreList
    recipeDF.to_csv('recipe.csv', index=False)
    recipeDF.to_csv('373FinalBobaShops/Recipe.csv', index=False)
    # print('Recipe DF: \n' , RecipeDF)
    return recipeDF
recipeDF = createRecipeCSV()
print('done recipe')
def createPurchaseCSV():
    # pk is purchase_id
    purDF = pd.DataFrame(columns = ['id', 'purchase_id', 'year', 'month', 'day', 'boba_id', 'quantity', 'price', 'isMember', 'member_id', 'store_id'])
    # make xNum of IDs for purchase
    idList = []
    # initialize 60,000 purchases
    for i in range(60000):
        idList.append(i)
    purDF['purchase_id'] = idList

    idList = []
    yearList = []
    monthList = []
    dateList = []
    isMemberOptions = ['TRUE', 'FALSE']
    isMemberList = []
    memberIDList = []
    memberList = memberDF['member_id']
    # recipeDF = createRecipeCSV()
    priceList = []
    bobaList = []
    storeList = []
    quantityList = []
    purIdList = []

    # get price of each boba drink
    idOptions = bobaDF['boba_id']
    for i in range(len(purDF)):
        # generate random unqiue IDs
        letters = string.ascii_lowercase
        id = 'i'+ ''.join(random.choice(letters) for j in range(9))
        purId = 'p' + ''.join(random.choice(letters) for j in range(9))
        while (id in idList):
            id = 'i'+''.join(random.choice(letters) for j in range(9))
        while (purId in idList):
            purId = 'p' +  ''.join(random.choice(letters) for j in range(9))
        idList.append(id)
        purIdList.append(purId)

        # setting year, month, day values
        year = str(random.randint(2012, 2022))
        month = str(random.randint(1, 12))
        date = str(random.randint(1,30))
        if (year == 2022):
            month = str(random.randint(1, 4))
            date = str(random.randint(1,30))
        if (int(date) < 10):
            date = str('0') + str(date)
        if (int(month) < 10):
            month = str('0') + str(month)
        yearList.append(year)
        monthList.append(month)
        dateList.append(date)

        # setting isMember & member_id values
        isMember = random.choice(isMemberOptions)
        isMemberList.append(isMember)
        # if isMember = TRUE, assign random memberID from member list 
        if (isMember == 'TRUE'):
            memberID = random.choice(memberList)
            memberIDList.append(memberID)
        else:
            memberIDList.append('NULL')

        # setting boba_id and getting respective store_id and price
        bobaId = random.choice(idOptions)
        bobaList.append(bobaId)
        storeId = recipeDF.loc[recipeDF['boba_id'] == bobaId, 'store_id']
        price = bobaDF.loc[bobaDF['boba_id'] == bobaId, 'price']
        storeList.append(storeId.values[0])
        priceList.append(price.values[0])
        quantity = random.randint(1,9)
        quantityList.append(quantity)

    purDF.id = idList
    purDF.purchase_id = purIdList
    purDF.year = yearList
    purDF.month = monthList
    purDF.day = dateList
    purDF['isMember'] = isMemberList
    purDF['member_id'] = memberIDList
    purDF['boba_id'] = bobaList
    purDF['store_id'] = storeList
    purDF['price'] = priceList
    purDF['quantity'] = quantityList

    # drinks from the same purchase
    # for every 5th element we set the next element equal to the prev's value's 
            # these values will have the sme purchase_id and smae year/month/day and isMember/member_id
    print('subset pur')
    i = 0
    while (i < len(purDF)): 
        if i % 10 == 0:
            # set next id equal to curr
            currId = purDF.loc[purDF.index[i], 'purchase_id']
            purDF.loc[purDF.index[i+1], 'purchase_id'] = currId
            currYear = purDF.loc[purDF.index[i], 'year']
            currMonth = purDF.loc[purDF.index[i], 'month']
            currDate = purDF.loc[purDF.index[i], 'day']
            purDF.loc[purDF.index[i+1], 'year'] = currYear
            purDF.loc[purDF.index[i+1], 'month'] = currMonth
            purDF.loc[purDF.index[i+1], 'day'] = currDate
            # set isMember & member_id
            currIsMember = purDF.loc[purDF.index[i], 'isMember']
            currMemberId = purDF.loc[purDF.index[i], 'member_id']
            purDF.loc[purDF.index[i+1], 'isMember'] = currIsMember
            purDF.loc[purDF.index[i+1], 'member_id'] = currMemberId
            #set store_id
            currStore = purDF.loc[purDF.index[i], 'store_id']
            purDF.loc[purDF.index[i+1], 'store_id'] = currStore
        i += 10

    # print('Purchase DF \n', purDF)
    purDF.to_csv('purchase.csv', index=False)
    purDF.to_csv('373FinalBobaShops/Purchase.csv', index=False)
    return purDF
purDF = createPurchaseCSV()
print('done pur')
def createShipmentCSV():
    # pk is order_id
    # ingredient_id comes from inventory, can choose randomly from list 
    # date_arrival must come before date_request (randomize these both)
    shipDF = pd.DataFrame(columns = ['order_id', 'request_id', 'shipment_number', 'ingredient_id', 'quantity', 'store_id', 'price', 'date_arrival', 'date_request'])
    ingrListOptions = invDF['ingredient_id'].tolist() # should be unique
    uniqueStoreList = storeDF['store_id']
    # orderList ,requestList, shipmentList, ingrList, quantityList, storeList, priceList, dateArrList, dateReqList= ([], ) * 9
    orderList = []
    requestList = []
    shipmentList= []
    ingrList= []
    quantityList= []
    storeList= []
    priceList= []
    dateAList= []
    dateRList= []
    yearList = []
    monthList = []
    dayList = []
    for i in range(50000):
        shipmentList.append(i+1)
    shipDF['shipment_number'] = shipmentList

    orderList = []
    for i in range(len(shipDF)):
        # create unique order_id & request_id
        letters = string.ascii_lowercase
        ordId = 'o'.join(random.choice(letters) for j in range(9))
        reqId = random.randint(1000, 90000000)
        while (ordId in orderList):
            ordId = 'o'.join(random.choice(letters) for j in range(9))
        while (reqId in orderList):
            reqId = random.randint(100, 90000000)

        orderList.append(ordId)
        requestList.append(reqId)
        # randomize ingredient_id
        ingredient_id = random.choice(ingrListOptions)
        ingrList.append(ingredient_id)
        # ingrListOptions.remove(ingredient_id)
        # randomize quantity
        quantity = random.randint(1,100)
        quantityList.append(quantity)
        # # assign random inventory(ingr_id)
        # ingredient_id = random.choice(ingrList)
        # from inventory_id get price and store
        if(ingredient_id not in invDF['ingredient_id'].tolist()):
            print('ingr not in list')
        storeId = invDF.loc[invDF['ingredient_id'] == ingredient_id, 'store_id']
        bobaID = recipeDF.loc[recipeDF['ingredient_id'] == ingredient_id, 'boba_id']

        price = bobaDF.loc[bobaDF['boba_id'] == bobaID.values[0], 'price']

        storeList.append(storeId.values[0])
        priceList.append(price.values[0])

        year = str(random.randint(2012, 2022))
        month = str(random.randint(1, 12))
        dateR = str(random.randint(1,25))
        dateA = str(int(dateR) + random.randint(1,3))

        if (year == 2022):
            month = str(random.randint(1, 4))
        if (int(dateR) < 10):
            dateR = str('0') + str(dateR)
        if (int(dateA) < 10):
            dateA = str('0') + str(dateA)
        if (int(month) < 10):
            month = str('0') + str(month)

        dateAList.append(year + '-' + month + '-' + dateA)
        dateRList.append(year + '-' + month + '-' + dateR)
    
    shipDF.order_id = orderList
    shipDF.request_id = requestList
    shipDF.ingredient_id = ingrList
    shipDF['quantity'] = quantityList
    shipDF.store_id = storeList
    shipDF.price = priceList
    shipDF.date_arrival = dateAList
    shipDF.date_request = dateRList



    print("Shipment \n", shipDF)
    shipDF.to_csv('shipment.csv', index=False)
    shipDF.to_csv('373FinalBobaShops/Shipment.csv', index=False)
    return shipDF
shipDF = createShipmentCSV()