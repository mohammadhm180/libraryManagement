import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Categories categories = new Categories();
        LibraryList libraryList = new LibraryList();
        People people = new People();
        Admin admin=new Admin();
        String input,order;
        ArrayList<Log> logs=new ArrayList<>();

        while (true){
            input=scanner.nextLine();
            if(input.equals("finish")) return;
            order=input.split("#")[0];
            String[] param = new String[0];
            input=input.split("#")[1];
            param=input.split("\\|");
            if(order.equals("add-library")){
                libraryList.addLibrary(param[0],param[1], new Library(param[2], param[3],Integer.parseInt(param[4]),Integer.parseInt(param[5]),param[6]),people,admin,logs);
                continue;
            }

            if(order.equals("add-category")){
                categories.addCategory(param[0],param[1],param[2],param[3],param[4],people,admin,logs);
                continue;
            }

            if (order.equals("add-book")){
                libraryList.addBook(param[0],param[1], new Book(param[2],param[3],param[4],param[5],Integer.parseInt(param[6]),
                        Integer.parseInt(param[7]),param[8],param[9]),categories,people,logs);
                continue;
            }
            if (order.equals("add-ganjineh-book")){
                libraryList.addGanginehBook(param[0],param[1], new GanjinehBook(param[2],param[3],param[4],param[5],Integer.parseInt(param[6]),
                        param[7], param[8],param[9]),categories,people,logs);
                continue;
            }
            if (order.equals("add-selling-book")){
                libraryList.addSellingBook(param[0],param[1], new SellingBook(param[2],param[3],param[4],param[5],Integer.parseInt(param[6]),
                        Integer.parseInt(param[7]),Integer.parseInt(param[8]),Integer.parseInt(param[9]),param[10],param[11]),categories,people,logs);
                continue;
            }
            if (order.equals("remove-resource")){
                libraryList.removeResource(param[0],param[1] ,param[2],param[3],people ,logs);
                continue;
            }
            if (order.equals("buy")){
                people.buy(param[0],param[1] ,param[2],param[3],libraryList,logs);
                continue;
            }
            if (order.equals("read")){
                Dates dates=new Dates(Integer.parseInt(param[4].split("-")[0]),Integer.parseInt(param[4].split("-")[1]),
                        Integer.parseInt(param[4].split("-")[2]),Integer.parseInt(param[5].split(":")[0]),Integer.parseInt(param[5].split(":")[1]));
                people.read(param[0],param[1] ,param[2],param[3],dates,libraryList );
                continue;
            }
            if (order.equals("add-comment")){
               libraryList.addComment (param[0],param[1] ,param[2],param[3],param[4],people,logs);
                continue;
            }
            if (order.equals("add-thesis")){
                libraryList.addThesis(param[0],param[1], new Thesis(param[2],param[3], param[4],param[5],Integer.parseInt(param[6]),param[7], param[8]),categories,people,logs);
                continue;
            }
            if (order.equals("add-student")){
                people.addStudent(param[0],param[1], new Student(param[2],param[3],param[4],param[5],param[6],Integer.parseInt(param[7]),param[8]),people,admin,logs);
                continue;
            }
            if (order.equals("remove-user")){
                people.removeUser(param[0],param[1],param[2],admin,people ,logs);
                continue;
            }
            if (order.equals("add-staff")){
                if(param[9].equals("staff")){
                    people.addStaff(param[0],param[1] ,new Staff(param[2],param[3],param[4],param[5],param[6],Integer.parseInt(param[7]),param[8]),admin,people,logs);
                    continue;
                }
                else {
                    people.addProfessor(param[0],param[1] ,new Professor(param[2],param[3],param[4],param[5],param[6],Integer.parseInt(param[7]),param[8]),admin,people,logs);
                    continue;
                }
            }
            if (order.equals("add-manager")){
                people.addManager(param[0],param[1] ,new Manager(param[2],param[3],param[4],param[5],param[6],Integer.parseInt(param[7]),param[8],param[9]),admin,people,libraryList,logs);
                continue;
            }
            if (order.equals("borrow")){
                Dates dates=new Dates(Integer.parseInt(param[4].split("-")[0]),Integer.parseInt(param[4].split("-")[1]),
                        Integer.parseInt(param[4].split("-")[2]),Integer.parseInt(param[5].split(":")[0]),Integer.parseInt(param[5].split(":")[1]));
                people.borrow(param[0],param[1],param[2],param[3],dates,libraryList ,logs);
                continue;
            }
            if (order.equals("return")){
                Dates dates=new Dates(Integer.parseInt(param[4].split("-")[0]),Integer.parseInt(param[4].split("-")[1]),
                        Integer.parseInt(param[4].split("-")[2]),Integer.parseInt(param[5].split(":")[0]),Integer.parseInt(param[5].split(":")[1]));
                people.returnObject(param[0],param[1],param[2],param[3],dates,libraryList ,logs);
                continue;
            }
            if (order.equals("search")){
                people.search(param[0],libraryList,categories );
                continue;
            }
            if (order.equals("report-most-popular")){
                people.reportMostPopular(param[0],param[1],param[2],libraryList,logs );
                continue;
            }
            if (order.equals("report-sell")){
                people.reportSell(param[0],param[1],param[2],libraryList,logs );
                continue;
            }
            if (order.equals("search-user")){
                people.searchUser(param[0],param[1],param[2] );
                continue;
            }
            if (order.equals("reserve-seat")){
                libraryList.reserveSeat(param[0],param[1],param[2],people,Integer.parseInt(param[3].split("-")[0]),Integer.parseInt(param[3].split("-")[1]),
                        Integer.parseInt(param[3].split("-")[2]),Integer.parseInt(param[4].split(":")[0]),Integer.parseInt(param[4].split(":")[1])
                        ,Integer.parseInt(param[5].split(":")[0]),Integer.parseInt(param[5].split(":")[1]));
                continue;
            }
            if (order.equals("category-report")){
                libraryList.categoryReport(param[0],param[1],param[2],param[3], categories,people);
                continue;
            }
            if (order.equals("library-report")){
                libraryList.libraryReport(param[0],param[1],param[2],people );
                continue;
            }
            if (order.equals("report-passed-deadline")){
                Dates dates=new Dates(Integer.parseInt(param[3].split("-")[0]),Integer.parseInt(param[3].split("-")[1]),
                        Integer.parseInt(param[3].split("-")[2]),Integer.parseInt(param[4].split(":")[0]),Integer.parseInt(param[4].split(":")[1]));
                libraryList.reportPassedDeadline(param[0],param[1],param[2], dates,people);
                continue;
            }
            if (order.equals("report-penalties-sum")){
                people.reportPenaltiesSum(param[0],param[1],admin );
                continue;
            }

        }
    }
}

class Log{
    private String user;
    private String order;
    private String result;
    private String libraryID;
    private Publication resource;
    Dates date;
    public Log(String user,String order,String result,Dates date){
        this.user=user;
        this.order=order;
        this.result=result;
        this.date=date;
        libraryID=null;
        resource=null;
    }
    public Log(String user,String order,String result){
        this.user=user;
        this.order=order;
        this.result=result;
        this.date=null;
        libraryID=null;
        resource=null;
    }
    public Log(String user,String order,String result,String libraryID,Publication resource){
        this.user=user;
        this.order=order;
        this.result=result;
        this.date=date;
        this.libraryID=libraryID;
        this.resource=resource;
    }
    public Log(String user,String order,String result,Dates date,String libraryID,Publication resource){
        this.user=user;
        this.order=order;
        this.result=result;
        this.date=date;
        this.libraryID=libraryID;
        this.resource=resource;
    }

    public String getUser() {
        return user;
    }

    public Publication getResource() {
        return resource;
    }

    public Dates getDate() {
        return date;
    }

    public String getLibraryID() {
        return libraryID;
    }

    public String getOrder() {
        return order;
    }

    public String getResult() {
        return result;
    }
}
class Category{
    private String categoryID;
    private String categoryName;
    private String categoryParent;
    public Category(String categoryID,String categoryName,String categoryParent){
        this.categoryID=categoryID;
        this.categoryParent=categoryParent;
        this.categoryName=categoryName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryParent() {
        return categoryParent;
    }
}


class Admin{
    private String userID;
    private String password;
    public Admin(){
        userID="admin";
        password="AdminPass";
    }
    public boolean checkAdmin(String adminUsername,String adminPass,People people){
        if(!adminUsername.equals(userID)){
            if(people.userExist(adminUsername)){
                System.out.println("permission-denied");
                return false;
            }
            System.out.println("not-found");
            return false;
        }
        if(!adminPass.equals(password)){
            System.out.println("invalid-pass");
            return false;
        }
        return true;
    }
}

class Categories {
    private ArrayList<Category>  categoryList;

    public Categories() {
        categoryList = new ArrayList<>();
        categoryList.add(new Category("null","null","null"));
    }

    public void addCategory(String adminUsername,String adminPass,String categoryId, String categoryName,String categoryParent,People people,Admin admin,ArrayList<Log> logs) {
        if(!admin.checkAdmin(adminUsername,adminPass,people)){
            return;
        }
        if (categoryExist(categoryId)) {
            System.out.println("duplicate-id");
            logs.add(new Log("admin","add-category","duplicate-id"));
            return;
        }
        if(!categoryExist(categoryParent)){
            System.out.println("not-found");
            logs.add(new Log("admin","add-category","not-found"));
            return;
        }
        categoryList.add(new Category(categoryId,categoryName,categoryParent));
        System.out.println("success");
        logs.add(new Log("admin","add-category","success"));
    }

    public ArrayList<Category> giveChildren(Category category){
        ArrayList<Category> categories=new ArrayList<>();
        if(category.getCategoryID().equals("null")) return categories;
        for (Category category1:categoryList){
            if(category1.getCategoryParent().equals(category.getCategoryID())){
                categories.add(category1);
            }
        }
        return categories;
    }
    public boolean isChild(ArrayList<Category> categories,String categoryID){
        for (Category category1:categories){
            if(category1.getCategoryID().equals(categoryID)) return true;
        }
        return false;
    }
    public boolean categoryExist(String categoryId) {
        if (categoryId.equals("null")) {
            return true;
        }
        for (Category category:categoryList) {
            if (category.getCategoryID().equals(categoryId)) {
                return true;
            }
        }
        return false;
    }
    public Category getCategory(String categoryId){
        for (Category category:categoryList) {
            if (category.getCategoryID().equals(categoryId)) {
                return category;
            }
        }
        return null;
    }
    public String getCategoryName(String categoryId){
        if (categoryId.equals("null")) {
            return "null";
        }
        Category category=getCategory(categoryId);
        if(category!=null){
            return category.getCategoryName();
        }
        return "---";
    }
}

class LibraryList {
    private ArrayList<Library> libraries;

    public LibraryList() {
        this.libraries = new ArrayList<>();
    }

    public void addLibrary(String adminUsername,String adminPass,Library library,People people,Admin admin,ArrayList<Log> logs) {
        if(!admin.checkAdmin(adminUsername,adminPass,people)){
            return;
        }
        if (libraryExist(library)) {
            System.out.println("duplicate-id");
            logs.add(new Log("admin","add-library","duplicate-id"));
            return;
        }
        libraries.add(library);
        System.out.println("success");
        logs.add(new Log("admin","add-library","success"));
    }

    public boolean libraryExist(Library library) {
        for (Library librarySearch : libraries) {
            if (library.getLibraryId().equals(librarySearch.getLibraryId())) {
                return true;
            }
        }
        return false;
    }

    public Library getLibrary(String libraryId) {
        for (Library librarySearch : libraries) {
            if (librarySearch.getLibraryId().equals(libraryId)) {
                return librarySearch;
            }
        }
        return null;
    }

    public void addBook(String managerUsername,String managerPass,Book book, Categories categories,People people,ArrayList<Log> logs) {
        if (!categories.categoryExist(book.getCategory())) {
            logs.add(new Log(managerUsername,"add-book","not-found"));
            System.out.println("not-found");
            return;
        }
        Library library = getLibrary(book.getLibraryId());
        if (library == null) {
            System.out.println("not-found");
            logs.add(new Log(managerUsername,"add-book","not-found"));
            return;
        }
        Manager manager=people.getManager(managerUsername);
        if(!people.managerCheck(manager,managerUsername,managerPass,book.getLibraryId(),logs,"add-book")){
            return;
        }
        if (library.resourceExist(book.getID())) {
            logs.add(new Log(managerUsername,"add-book","duplicate-id"));
            System.out.println("duplicate-id");
            return;
        }
        manager.addBook(library,book);
        System.out.println("success");
        logs.add(new Log(managerUsername,"add-book","success"));

    }
    public void addSellingBook(String managerUsername,String managerPass,SellingBook sellingBook, Categories categories,People people,ArrayList<Log> logs) {
        if (!categories.categoryExist(sellingBook.getCategory())) {
            logs.add(new Log(managerUsername,"add-seeling-book","not-found"));
            System.out.println("not-found");
            return;
        }
        Library library = getLibrary(sellingBook.getLibraryId());
        if (library == null) {
            System.out.println("not-found");
            logs.add(new Log(managerUsername,"add-seeling-book","not-found"));
            return;
        }
        Manager manager=people.getManager(managerUsername);
        if(!people.managerCheck(manager,managerUsername,managerPass,sellingBook.getLibraryId(),logs,"add-seeling-book")){
            return;
        }
        if (library.resourceExist(sellingBook.getID())) {
            System.out.println("duplicate-id");
            logs.add(new Log(managerUsername,"add-seeling-book","duplicate-id"));
            return;
        }
        manager.addSellingBook(library,sellingBook);
        logs.add(new Log(managerUsername,"add-seeling-book","success"));
        System.out.println("success");
    }
    public void addGanginehBook(String managerUsername,String managerPass,GanjinehBook ganjinehBook, Categories categories,People people,ArrayList<Log> logs) {
        if (!categories.categoryExist(ganjinehBook.getCategory())) {
            logs.add(new Log(managerUsername,"add-ganjineh-book","not-found"));
            System.out.println("not-found");
            return;
        }
        Library library = getLibrary(ganjinehBook.getLibraryId());
        if (library == null) {
            logs.add(new Log(managerUsername,"add-ganjineh-book","not-found"));
            System.out.println("not-found");
            return;
        }
        Manager manager=people.getManager(managerUsername);
        if(!people.managerCheck(manager,managerUsername,managerPass,ganjinehBook.getLibraryId(),logs,"add-ganjineh-book")){
            return;
        }
        if (library.resourceExist(ganjinehBook.getID())) {
            logs.add(new Log(managerUsername,"add-ganjineh-book","duplicate-id"));
            System.out.println("duplicate-id");
            return;
        }
        manager.addGanginehBook(library,ganjinehBook);
        System.out.println("success");
        logs.add(new Log(managerUsername,"add-ganjineh-book","success"));
    }

    public void removeResource(String managerUsername,String managerPass,String bookId, String libraryId,People people,ArrayList<Log> logs) {
        Library library = getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            logs.add(new Log(managerUsername,"remove-resource","not-found"));
            return;
        }
        Manager manager=people.getManager(managerUsername);
        if(!people.managerCheck(manager,managerUsername,managerPass,libraryId,logs,"remove-resource")){
            return;
        }
        manager.removeResource(library,bookId,logs);

    }
    public void addComment(String userName, String password, String libraryId, String wanted,String comment,People people,ArrayList<Log> logs){
        Library library = getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            logs.add(new Log(null,"add-comment","not-found"));
            return;
        }
        Person person=people.getUser(userName);
        if(person instanceof Student || person instanceof Professor);
        else if(person instanceof Staff || person instanceof Manager){
            System.out.println("permission-denied");
            logs.add(new Log(null,"add-comment","permission-denied"));
            return;
        }
        else {
            System.out.println("not-found");
            logs.add(new Log(null,"add-comment","not-found"));
            return;
        }
        if(!person.getPassword().equals(password)){
            System.out.println("invalid-pass");
            logs.add(new Log(userName,"add-comment","invalid-pass"));
            return;
        }
        Publication publication=library.getPublication(wanted);
        if(!(publication instanceof Book)){
            System.out.println("not-found");
            logs.add(new Log(userName,"add-comment","not-found"));
            return;
        }
        ((CanComment) person).addComment(comment, (Book) publication);
        System.out.println("success");
        logs.add(new Log(userName,"add-comment","success"));
    };

    public void addThesis(String managerUsername,String managerPass,Thesis thesis, Categories categories,People people,ArrayList<Log> logs) {
        if (!categories.categoryExist(thesis.getCategory())) {
            System.out.println("not-found");
            logs.add(new Log(managerUsername,"add-thesis","not-found"));
            return;
        }
        Library library = getLibrary(thesis.getLibraryId());
        if (library == null) {
            System.out.println("not-found");
            logs.add(new Log(managerUsername,"add-thesis","not-found"));
            return;
        }
        Manager manager=people.getManager(managerUsername);
        if(!people.managerCheck(manager,managerUsername,managerPass,thesis.getLibraryId(),logs,"add-thesis")){
            return;
        }
        if (library.resourceExist(thesis.getID())) {
            System.out.println("duplicate-id");
            logs.add(new Log(managerUsername,"add-thesis","duplicate-id"));
            return;
        }
        manager.addThesis(library,thesis);
        System.out.println("success");
        logs.add(new Log(managerUsername,"add-thesis","success"));

    }

    public ArrayList<Library> getLibraries() {
        return libraries;
    }

    public void categoryReport(String managerUsername,String managerPass,String categoryID,String libraryId, Categories categoryList,People people) {
        if (!categoryList.categoryExist(categoryID)) {
            System.out.println("not-found");
            return;
        }
        Library library = getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            return;
        }
        Manager manager=people.getManager(managerUsername);
        if(!people.managerCheck(manager,managerUsername,managerPass,libraryId)){
            return;
        }
        Category category=categoryList.getCategory(categoryID);
        manager.categoryReport(category,library,categoryList);
    }

    public void libraryReport(String managerUsername,String managerPass,String libraryId,People people) {
        Library library = getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            return;
        }
        Manager manager=people.getManager(managerUsername);
        if(!people.managerCheck(manager,managerUsername,managerPass,libraryId)){
            return;
        }
        manager.libraryReport(library);
    }

    public void reportPassedDeadline(String managerUsername,String managerPass,String libraryId, Dates date,People people) {
        Library library = getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            return;
        }
        Manager manager=people.getManager(managerUsername);
        if(!people.managerCheck(manager,managerUsername,managerPass,libraryId)){
            return;
        }
        manager.reportPassedDeadline(library,date);
    }
    public void reserveSeat(String userId,String pass,String libraryId,People people,int year,int month,
                            int day,int hour1,int minute1,int hour2,int minute2){
        Library library = getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            return;
        }
        Person person=people.getUser(userId);
        if(person instanceof Student || person instanceof Professor);
        else if(person instanceof Staff || person instanceof Manager){
            System.out.println("permission-denied");
            return;
        }
        else {
            System.out.println("not-found");
            return;
        }
        if (!person.getPassword().equals(pass)) {
            System.out.println("invalid-pass");
            return;
        }
        int differentMinute=(hour2-hour1)*60 + (minute2-minute1);
        if(differentMinute>8*60){
            System.out.println("not-allowed");
            return;
        }
        for (Library library1:libraries){
            for (ReservedSeat reservedSeat:library1.getReservedSeats()){
                if(reservedSeat.getDates().getYear()==year && reservedSeat.getDates().getMonth()==month && reservedSeat.getDates().getDay()==day){
                    if(reservedSeat.getUserId().equals(userId)){
                        System.out.println("not-allowed");
                        return;
                    }
                }
            }
        }
        int reservedSeats=0;
        for (ReservedSeat reservedSeat:library.getReservedSeats()){
            if(reservedSeat.getDates().getYear()==year && reservedSeat.getDates().getMonth()==month && reservedSeat.getDates().getDay()==day){
                if(reservedSeat.getUserId().equals(userId)){
                    System.out.println("not-allowed");//a person cant reserve two seat in a library
                    return;
                }
                int startHours1=hour1,startMinutes1=minute1,endHours1=hour2,endMinutes1=minute2;
                int startHours2=reservedSeat.getStartHour(),startMinutes2=reservedSeat.getStartMinute(),endHours2=reservedSeat.getEndHour();
                int endMinutes2=reservedSeat.getEndMinute();
                if (startHours1 == startHours2 && endHours1 == endHours2 && startMinutes1 == startMinutes2 && endMinutes1 == endMinutes2) {
                    reservedSeats++;
                } else if (endHours1 < startHours2 || (endHours1 == startHours2 && endMinutes1 <= startMinutes2) || endHours2 < startHours1 || (endHours2 == startHours1 && endMinutes2 <= startMinutes1)) {
                    ;//in this case they are separated
                } else {
                    reservedSeats++;
                }
            }
        }
        if(reservedSeats==library.getTableNumber()){
            System.out.println("not-available");
            return;
        }
        library.getReservedSeats().add(new ReservedSeat(userId,libraryId,new Dates(year,month,day,0,0),hour1,minute1,hour2,minute2));
        System.out.println("success");
    }
}

class LogInfo{
    private String sourceID;
    private int number;
    private long hour;
    public LogInfo(String sourceID,long hour){
        this.sourceID=sourceID;
        this.hour=hour;
        number=1;
    }
    public void addLog(long hour){
        number++;
        this.hour+=hour;
    }

    public String getSourceID() {
        return sourceID;
    }

    public long getHour() {
        return hour;
    }

    public int getNumber() {
        return number;
    }
}
class SellInfo{
    private String sourceID;
    private int numberOfSell;
    private double sumOfSell;
    public SellInfo(String sourceID,double finalPrice){
        this.sourceID=sourceID;
        numberOfSell=1;
        sumOfSell=finalPrice;
    }

    public String getSourceID() {
        return sourceID;
    }

    public int getNumberOfSell() {
        return numberOfSell;
    }

    public double getSumOfSell() {
        return sumOfSell;
    }
    public void addSell(double finalPrice){
        numberOfSell++;
        sumOfSell+=finalPrice;
    }
}
class People {
    private ArrayList<Person> personArrayList;

    public People() {
        personArrayList=new ArrayList<>();
    }
    public Person getUser(String userID){
        for (Person person:personArrayList){
            if(person.getUserId().equals(userID))
                return person;
        }
        return null;
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void reportMostPopular(String managerUsername, String managerPass, String libraryId, LibraryList libraryList, ArrayList<Log> logs){
        Library library =libraryList.getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            return;
        }
        Manager manager=getManager(managerUsername);
        if(!managerCheck(manager,managerUsername,managerPass,libraryId)){
            return;
        }
        ArrayList<Log> borrowLogs=new ArrayList<>();
        ArrayList<Log> returnLogs=new ArrayList<>();
        for (Log log:logs){
            if(log.getOrder().equals("borrow") && log.getResult().equals("success")){
                if(log.getLibraryID().equals(libraryId)){
                    borrowLogs.add(log);
                    continue;
                }
            }
            if(log.getOrder().equals("return") && log.getResult().equals("success") ){
                if(log.getLibraryID().equals(libraryId)){
                    returnLogs.add(log);
                }
            }
        }
        ArrayList<LogInfo> bookLogInfos=new ArrayList<>();
        ArrayList<LogInfo> thesisLogInfos=new ArrayList<>();
        Iterator<Log> returnLogIt;
        for (Log borrowLog:borrowLogs){
            returnLogIt=returnLogs.iterator();
            while (returnLogIt.hasNext()){
                Log returnLog=returnLogIt.next();
                if(returnLog.getUser().equals(borrowLog.getUser()) && returnLog.getResource().getID().equals(borrowLog.getResource().getID())){
                    LocalDateTime dateTime1 = LocalDateTime.of(returnLog.getDate().getYear(), returnLog.getDate().getMonth(),
                            returnLog.getDate().getDay(), returnLog.getDate().getHour(), returnLog.getDate().getMinute());

                    LocalDateTime dateTime2 = LocalDateTime.of(borrowLog.getDate().getYear(), borrowLog.getDate().getMonth(),
                            borrowLog.getDate().getDay(),borrowLog.getDate().getHour(), borrowLog.getDate().getMinute());

                    Duration duration = Duration.between(dateTime2, dateTime1);
                    long hoursBetween = duration.toHours() ;
                    if(returnLog.getResource() instanceof Book)
                        addLogInfo(borrowLog.getResource().getID(),hoursBetween,bookLogInfos);
                    if(returnLog.getResource() instanceof Thesis)
                        addLogInfo(borrowLog.getResource().getID(),hoursBetween,thesisLogInfos);
                    returnLogIt.remove();
                    break;
                }
            }
        }
        if(bookLogInfos.size()>0){
            LogInfo most=bookLogInfos.get(0);
            for (LogInfo logInfo:bookLogInfos){
                if(logInfo.getHour()>most.getHour()) most=logInfo;
            }
            double bookDays=Math.ceil((double) most.getHour()/24);
            System.out.println(most.getSourceID()+" "+most.getNumber()+" "+(int)bookDays);
        }
        else System.out.println("null");
        if(thesisLogInfos.size()>0){
            LogInfo most2=thesisLogInfos.get(0);
            for (LogInfo logInfo:thesisLogInfos){
                if(logInfo.getHour()>most2.getHour()) most2=logInfo;
            }
            double thesisDays=Math.ceil((double) most2.getHour()/24);
            System.out.println(most2.getSourceID()+" "+most2.getNumber()+" "+(int)thesisDays);
        }
        else System.out.println("null");
    }
    public Manager getManager(String ID){
        for (Person person:personArrayList){
            if(person.getUserId().equals(ID) && person instanceof Manager)
                return (Manager) person;
        }
        return null;
    }
    public void reportSell(String managerUsername,String managerPass,String libraryId,LibraryList libraryList,ArrayList<Log> logs){
        Library library =libraryList.getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            return;
        }

        Manager manager=getManager(managerUsername);
        if(!managerCheck( manager,managerUsername,managerPass,libraryId)){
            return;
        }
        ArrayList<SellInfo> sellInfos=new ArrayList<>();
        for (Log log:logs){
            if(log.getOrder().equals("buy") && log.getResult().equals("success") && log.getLibraryID().equals(libraryId)){
                double finalPrice=((double) ((SellingBook)log.getResource()).getPrice())*(100-(double) ((SellingBook)log.getResource()).getDiscount())/100;
                addSellInfo(log.getResource().getID(),finalPrice,sellInfos);
            }
        }
        if(sellInfos.size()>0){
            double totalSum=0;
            int totalSellNumber=0;
            SellInfo max=sellInfos.get(0);
            for (SellInfo sellInfo:sellInfos){
                totalSum+=sellInfo.getSumOfSell();
                totalSellNumber+=sellInfo.getNumberOfSell();
                if(sellInfo.getNumberOfSell()>max.getNumberOfSell())
                    max=sellInfo;
            }
            System.out.println(totalSellNumber+" "+(int)Math.ceil(totalSum));
            System.out.println(max.getSourceID()+" "+max.getNumberOfSell()+" "+(int)max.getSumOfSell());
        }
        else System.out.println("null");


    }
    public void addSellInfo(String sourceID,double finalPrice,ArrayList<SellInfo> sellInfos){
        for(SellInfo sellInfo:sellInfos){
            if(sellInfo.getSourceID().equals(sourceID)){
                sellInfo.addSell(finalPrice);
                return;
            }
        }
        sellInfos.add(new SellInfo(sourceID,finalPrice));
    }
    public void addLogInfo(String sourceID,long hour,ArrayList<LogInfo> logInfos){
        for (LogInfo logInfo:logInfos){
            if(sourceID.equals(logInfo.getSourceID())){
                logInfo.addLog(hour);
                return;
            }
        }
        logInfos.add(new LogInfo(sourceID,hour));
    }
    public boolean userExist(String username){
        for (Person person:personArrayList){
            if(person.getUserId().equals(username))
                return true;
        }
        return false;
    }

    public boolean managerCheck(Manager manager, String managerUsername, String managerPass, String libraryId, ArrayList<Log> logs, String order){
        if(manager==null){
            Person person=getUser(managerUsername);
            if(person instanceof Staff || person instanceof Student || person instanceof Professor ){
                System.out.println("permission-denied");
                logs.add(new Log(null,order,"permission-denied"));
                return false;
            }
            System.out.println("not-found");
            logs.add(new Log(null,order,"not-found"));
            return false;
        }
        if(!libraryId.equals(manager.getWorkingLibrary())){
            System.out.println("permission-denied");
            logs.add(new Log(manager.getUserId(),order,"permission-denied"));
            return false;
        }
        if(!manager.getPassword().equals(managerPass)){
            System.out.println("invalid-pass");
            logs.add(new Log(manager.getUserId(),order,"invalid-pass"));
            return false;
        }
        return true;
    }
    public boolean managerCheck(Manager manager,String managerUsername,String managerPass,String libraryId){
        if(manager==null){
            Person person=getUser(managerUsername);
            if(person instanceof Staff || person instanceof Student || person instanceof Professor){
                System.out.println("permission-denied");
                return false;
            }
            System.out.println("not-found");
            return false;
        }
        if(!libraryId.equals(manager.getWorkingLibrary())){
            System.out.println("permission-denied");
            return false;
        }
        if(!manager.getPassword().equals(managerPass)){
            System.out.println("invalid-pass");
            return false;
        }
        return true;
    }

    public void addStudent(String adminUsername,String adminPass,Student student,People people,Admin admin,ArrayList<Log>logs) {
        if(!admin.checkAdmin(adminUsername,adminPass,people)){
            return;
        }
        if(userExist(student.getUserId())){
            System.out.println("duplicate-id");
            logs.add(new Log(adminUsername,"add-student","duplicate-id"));
            return;
        }
        personArrayList.add(student);
        logs.add(new Log(adminUsername,"add-student","success"));
        System.out.println("success");
    }

    public void removeUser(String adminUsername,String adminPass,String userID,Admin admin,People people,ArrayList<Log>logs) {
        if(!admin.checkAdmin(adminUsername,adminPass,people)){
            return;
        }
        Iterator<Person> it = personArrayList.iterator();
        while (it.hasNext()) {
            Person person = it.next();
            if (person.getUserId().equals(userID)) {
                if(person instanceof Staff || person instanceof Student || person instanceof Professor){
                    if (((LibraryUser) person).getTakenObjects().size() != 0 || ((LibraryUser) person).getPenalty() != 0) {
                        System.out.println("not-allowed");
                        logs.add(new Log(adminUsername,"remove-user","not-allowed"));
                        return;
                    }
                }
                it.remove();
                System.out.println("success");
                logs.add(new Log(adminUsername,"remove-user","success"));
                return;
            }
        }
        System.out.println("not-found");
        logs.add(new Log(adminUsername,"remove-user","not-found"));
    }

    public void addStaff(String adminUsername,String adminPass,Staff staff,Admin admin,People people,ArrayList<Log>logs) {
        if(!admin.checkAdmin(adminUsername,adminPass,people)){
            return;
        }
        if (userExist(staff.getUserId())) {
            System.out.println("duplicate-id");
            logs.add(new Log(adminUsername,"add-staff","duplicate-id"));
            return;
        }
        personArrayList.add(staff);
        System.out.println("success");
        logs.add(new Log(adminUsername,"add-staff","success"));
    }
    public void addProfessor(String adminUsername,String adminPass,Professor professor,Admin admin,People people,ArrayList<Log>logs) {
        if(!admin.checkAdmin(adminUsername,adminPass,people)){
            return;
        }
        if (userExist(professor.getUserId())) {
            System.out.println("duplicate-id");
            logs.add(new Log(adminUsername,"add-professor","duplicate-id"));
            return;
        }
        personArrayList.add(professor);
        System.out.println("success");
        logs.add(new Log(adminUsername,"add-professor","success"));
    }

    public void addManager(String adminUsername,String adminPass,Manager manager,Admin admin,People people,LibraryList libraryList,ArrayList<Log>logs) {
        if(!admin.checkAdmin(adminUsername,adminPass,people)){
            return;
        }
        if (libraryList.getLibrary(manager.getWorkingLibrary()) == null) {
            System.out.println("not-found");
            logs.add(new Log(adminUsername,"add-manager","not-found"));
            return;
        }
        if (userExist(manager.getUserId())) {
            System.out.println("duplicate-id");
            logs.add(new Log(adminUsername,"add-manager","duplicate-id"));
            return;
        }
        personArrayList.add(manager);
        System.out.println("success");
        logs.add(new Log(adminUsername,"add-manager","success"));
    }

    public void borrow(String userName, String password, String libraryId, String wanted, Dates date, LibraryList libraryList,ArrayList<Log> logs) {
        Library library = libraryList.getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            logs.add(new Log("unknown","borrow","not-found",date,libraryId,null));
            return;
        }
        Person person=getUser(userName);
        if(person instanceof Staff || person instanceof Student || person instanceof Professor|| person instanceof Manager) ;
        else {
            System.out.println("not-found");
            logs.add(new Log("unknown","borrow","not-found",date,libraryId,null));
            return;
        }
        if(!person.getPassword().equals(password)){
            System.out.println("invalid-pass");
            logs.add(new Log(person.getUserId(),"borrow","invalid-pass",date,libraryId,null));
            return;
        }
        person.borrow(library,wanted,date,logs);
    }

    public void buy(String userName, String password, String libraryId, String wanted, LibraryList libraryList,ArrayList<Log> logs) {
        Library library = libraryList.getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            logs.add(new Log(userName,"buy","not-found",null,null));
            return;
        }
        Person person=getUser(userName);
        if(person==null){
            System.out.println("not-found");
            logs.add(new Log(userName,"buy","not-found",libraryId,null));
            return;
        }
        if(!person.getPassword().equals(password)){
            System.out.println("invalid-pass");
            logs.add(new Log(userName,"buy","invalid-pass",libraryId,null));
            return;
        }
        Publication publication=library.getPublication(wanted);
        if(!(publication instanceof SellingBook)){
            if(publication instanceof Book || publication instanceof Thesis){
                System.out.println("not-allowed");
                logs.add(new Log(userName,"buy","not-allowed",libraryId,null));
                return;
            }
            else {
                System.out.println("not-found");
                logs.add(new Log(userName,"buy","not-found",libraryId,null));
                return;
            }
        }
        if(((SellingBook)(publication)).getBookNumber()==0){
            System.out.println("not-allowed");
            logs.add(new Log(userName,"buy","not-allowed",libraryId,publication));
            return;
        }
        person.buy((SellingBook) publication,library,logs);
    }
    public void read(String userName, String password, String libraryId, String wanted,Dates date, LibraryList libraryList){
        Library library = libraryList.getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            return;
        }
        Person person;
        person = getUser(userName);
        if(person==null){
            System.out.println("not-found");
            return;
        }
        if(!person.getPassword().equals(password)){
            System.out.println("invalid-pass");
            return;
        }
        Publication publication=library.getPublication(wanted);
        if(!(publication instanceof GanjinehBook)){
            if(publication instanceof Book || publication instanceof Thesis){
                System.out.println("not-allowed");
                return;
            }
            System.out.println("not-found");
            return;
        }
        person.read((GanjinehBook) publication,date);
    }
    public void returnObject(String userName, String password, String libraryId, String wanted, Dates date, LibraryList libraryList,ArrayList<Log> logs) {

        Person person=getUser(userName);
        if(person instanceof Staff || person instanceof Student || person instanceof Professor) ;
        else if(person instanceof Manager){
            System.out.println("permission-denied");
            logs.add(new Log("unknown","borrow","permission-denied",date,libraryId,null));
            return;
        }
        else {
            System.out.println("not-found");
            logs.add(new Log("unknown","return","not-found",date,null,null));
            return;
        }
        if (!person.getPassword().equals(password)) {
            System.out.println("invalid-pass");
            logs.add(new Log(userName,"return","invalid-pass",date,null,null));
            return;
        }
        Library library = libraryList.getLibrary(libraryId);
        if (library == null) {
            System.out.println("not-found");
            logs.add(new Log(userName,"return","not-found",date,null,null));
            return;
        }
        Publication publication = library.getPublication(wanted);
        if (publication!=null && publication.getTakenObjects().size()!=0 ) {
            ArrayList<TakenObject> foundBooks=new ArrayList<>();
            Iterator<TakenObject> takenObjectIterator = publication.getTakenObjects().iterator();
            while (takenObjectIterator.hasNext()) {
                TakenObject takenObjectTemp = takenObjectIterator.next();
                if (takenObjectTemp.getTakerId().equals(person.getUserId())) {
                    foundBooks.add(takenObjectTemp);
                }
            }
            if(foundBooks.size()==0){
                System.out.println("not-found");
                logs.add(new Log(userName,"return","not-found",date,libraryId,null));
                return;
            }
            //finding latest date between same books
            TakenObject takenObject=foundBooks.get(0);
            for (int i=1;i<foundBooks.size();i++){
                TakenObject TO=foundBooks.get(i);
                if(TO.getTakenDate().getYear()<takenObject.getTakenDate().getYear() ||
                        (TO.getTakenDate().getYear()==takenObject.getTakenDate().getYear() && TO.getTakenDate().getMonth()<takenObject.getTakenDate().getMonth())||
                        (TO.getTakenDate().getYear()==takenObject.getTakenDate().getYear() && TO.getTakenDate().getMonth()==takenObject.getTakenDate().getMonth() &&
                                TO.getTakenDate().getDay()<takenObject.getTakenDate().getDay())){
                    takenObject=TO;
                }
            }

            LocalDateTime dateTime1 = LocalDateTime.of(takenObject.getTakenDate().getYear(), takenObject.getTakenDate().getMonth(),
                    takenObject.getTakenDate().getDay(), takenObject.getTakenDate().getHour(), takenObject.getTakenDate().getMinute());
            LocalDateTime dateTime2 = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), date.getHour(), date.getMinute());
            Duration duration = Duration.between(dateTime1, dateTime2);
            long hoursBetween = duration.toHours() ;
            int penalty = 0;
            if(publication instanceof Book){
                if (person instanceof Student) {
                    if (hoursBetween > 10*24) {
                        penalty = (int) (hoursBetween - 10 * 24) * 50;
                        ((Student) person).setPenalty(((Student) person).getPenalty() + penalty);
                    }
                } else {
                    if (hoursBetween > 14*24) {
                        penalty = (int) (hoursBetween - 14 * 24) * 100;
                        ((Staff) person).setPenalty(((Staff) person).getPenalty() + penalty);
                    }
                }
                ((Book) publication).setBookNumber(((Book) publication).getBookNumber()+1);
            }
            else {
                if (person instanceof Student) {
                    if (hoursBetween> 7*24) {
                        penalty=(int) (hoursBetween - 7 * 24) * 50;
                        ((Student) person).setPenalty(((Student) person).getPenalty() + penalty);
                    }
                } else {
                    if (hoursBetween> 10*24) {
                        penalty= (int) (hoursBetween - 10 * 24) * 100;
                        ((Staff) person).setPenalty(((Staff) person).getPenalty() + penalty);
                    }
                }
                ((Thesis) (publication)).setIsTaken(false);
            }
            Iterator<TakenObject> takenObjectIterator1 = ((LibraryUser) person).getTakenObjects().iterator();
            while (takenObjectIterator1.hasNext()) {
                TakenObject takenObject1 = takenObjectIterator1.next();
                if (takenObject1==takenObject) {
                    takenObjectIterator1.remove();
                    break;
                }
            }

            takenObjectIterator = publication.getTakenObjects().iterator();
            while (takenObjectIterator.hasNext()){
                if(takenObjectIterator.next()==takenObject){
                    takenObjectIterator.remove();
                }
            }
            if (penalty == 0) System.out.println("success");
            else System.out.println(penalty);
            logs.add(new Log(userName,"return","success",date,libraryId,publication));
            return;
        }
        System.out.println("not-found");
        logs.add(new Log(userName,"return","not-found",date,libraryId,null));
    }

    public void search(String key, LibraryList libraryList,Categories categories) {
        ArrayList<String> foundSet = new ArrayList<>();
        for (Library library : libraryList.getLibraries()) {
            for (Publication publication : library.getPublications()) {
                if (publication.getID().toLowerCase().contains(key.toLowerCase())|| categories.getCategoryName(publication.getCategory()).toLowerCase().contains(key.toLowerCase())) {
                    foundSet.add(publication.getID());
                    continue;
                }
                if (publication.getWriter().toLowerCase().contains(key.toLowerCase())) {
                    foundSet.add(publication.getID());
                    continue;
                }
                if(publication instanceof Book){
                    if (((Book) publication).getBookPublisher().toLowerCase().contains(key.toLowerCase())) {
                        foundSet.add(publication.getID());
                        continue;
                    }
                    if(publication instanceof GanjinehBook){
                        if (((GanjinehBook) publication).getDonor().toLowerCase().contains(key.toLowerCase())) {
                            foundSet.add(publication.getID());
                            continue;
                        }
                    }
                }
                else {
                    if (((Thesis)(publication)).getSupervisorName().toLowerCase().contains(key.toLowerCase())) {
                        foundSet.add(publication.getID());
                        continue;
                    }
                }
                if (publication.getName().toLowerCase().contains(key.toLowerCase())) {
                    foundSet.add(publication.getID());
                    continue;
                }
                for (TakenObject takenObject : publication.getTakenObjects()) {
                    if (takenObject.getTakerId().toLowerCase().contains(key.toLowerCase())) {
                        foundSet.add(publication.getID());
                        break;
                    }
                }
            }
        }
        if (foundSet.size() == 0) {
            System.out.println("not-found");
        } else {
            foundSet.sort(null);
            for (int i = 0; i < foundSet.size(); i++) {
                System.out.printf("%s", foundSet.get(i));
                if (i != foundSet.size() - 1) System.out.printf("|");
            }
            System.out.println();
        }
    }

    public void searchUser(String userName, String pass, String key) {
        Person person = getUser(userName);
        if(person instanceof Staff || person instanceof Student || person instanceof Professor ||person instanceof Manager);
        else {
            System.out.println("not-found");
            return;
        }
        if (!person.getPassword().equals(pass)) {
            System.out.println("invalid-pass");
            return;
        }
        person.searchUser(key,this);
    }
    public ArrayList<LibraryUser> getLibraryUsers(){
        ArrayList<LibraryUser> libraryUsers=new ArrayList<>();
        for (Person person:personArrayList){
            if(person instanceof Student || person instanceof Staff || person instanceof Professor){
                libraryUsers.add((LibraryUser) person);
            }
        }
        return libraryUsers;
    }
    public void reportPenaltiesSum(String adminUsername,String adminPass,Admin admin){
        if(!admin.checkAdmin(adminUsername,adminPass,this)){
            return;
        }
        int penaltySum=0;
        for (LibraryUser person:getLibraryUsers()){
            penaltySum+=person.getPenalty();
        }
        System.out.println(penaltySum);
    }
}


class Dates {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public Dates(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}


class Library {
    private String libraryId;
    private String libraryName;
    private int foundationDate;
    private String Address;
    private int tableNumber;
    private ArrayList<Publication> publications;
    private ArrayList<ReservedSeat> reservedSeats;

    public Library(String libraryId, String libraryName, int foundationDate, int tableNumber,String Address) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.foundationDate = foundationDate;
        this.Address = Address;
        this.tableNumber = tableNumber;
        reservedSeats=new ArrayList<>();
        publications=new ArrayList<>();
    }

    public String getLibraryId() {
        return this.libraryId;
    }


    public Publication getPublication(String publicationID) {
        for (Publication publication : publications) {
            if (publication.getID().equals(publicationID)) {
                return publication;
            }
        }
        return null;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean resourceExist(String ID){
        for (Publication publication : publications) {
            if (ID.equals(publication.getID())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }
    public ArrayList<ReservedSeat> getReservedSeats() {
        return reservedSeats;
    }
}


abstract class Publication{
    private String ID;
    private String name;
    private String writer;
    private String category;
    private String libraryId;
    private ArrayList<TakenObject> takenObjects;

    public Publication(String ID, String name, String writer, String category, String libraryId) {
        this.ID = ID;
        this.name = name;
        this.writer = writer;
        this.category = category;
        this.libraryId = libraryId;
        takenObjects=new ArrayList<>();
    }

    public ArrayList<TakenObject> getTakenObjects() {
        return takenObjects;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public String getCategory() {
        return category;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }
}

class Book extends Publication {
    private String bookPublisher;
    private int publishedYear;
    private int bookNumber;
    private ArrayList<Comment> comments;

    public Book(String bookID, String bookName, String bookWriter, String bookPublisher, int publishedYear, int bookNumber,
        String bookCategory, String libraryId) {
            super(bookID,bookName,bookWriter,bookCategory,libraryId);
        this.bookPublisher = bookPublisher;
        this.publishedYear = publishedYear;
        this.bookNumber = bookNumber;
        comments=new ArrayList<>();
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
}


class GanjinehBook extends Book {
    private String donor;
    private Dates startReading;
    public GanjinehBook(String bookID, String bookName, String bookWriter, String bookPublisher, int publishedYear,
                        String donor,String bookCategory, String libraryId) {
        super(bookID,bookName,bookWriter,bookPublisher,publishedYear,1,bookCategory,libraryId);
        this.donor=donor;
        startReading=new Dates(-1,-1,-1,-1,-1);
    }

    public Dates getStartReading() {
        return startReading;
    }

    public String getDonor() {
        return donor;
    }

    public void setStartReading(Dates startReading) {
        this.startReading = startReading;
    }
}


class SellingBook extends Book {
    private int price;
    private int discount;
    public SellingBook(String bookID, String bookName, String bookWriter, String bookPublisher, int publishedYear,
                        int bookNumber,int price,int discount,String bookCategory, String libraryId) {
        super(bookID,bookName,bookWriter,bookPublisher,publishedYear,bookNumber,bookCategory,libraryId);
        this.price=price;
        this.discount=discount;
    }

    public int getDiscount() {
        return discount;
    }

    public int getPrice() {
        return price;
    }
}


class Thesis extends Publication{
    private String supervisorName;
    private int defendYear;
    boolean isTaken;

    public Thesis(String thesisId, String thesisName, String thesisWriter, String supervisorName, int defendYear,
                  String thesisCategory, String libraryId) {
        super(thesisId,thesisName,thesisWriter,thesisCategory,libraryId);
        this.supervisorName = supervisorName;
        this.defendYear = defendYear;
        isTaken = false;
    }

    public String getSupervisorName() {
        return supervisorName;
    }
    public boolean getIsTaken() {
        return isTaken;
    }
    public void setIsTaken(boolean taken) {
        isTaken = taken;
    }


}


class Comment{
    String text;
    public Comment(String text){
        this.text=text;
    }

    public String getText() {
        return text;
    }
}


abstract class Person {
    private String userId;
    private String password;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private int birthYear;
    private String Address;


    public Person(String userId, String password, String firstName, String lastName, String nationalCode,
                  int birthYear, String Address) {
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthYear=birthYear;
        this.Address = Address;
    }

    public abstract void buy(SellingBook sellingBook,Library library,ArrayList<Log> logs);
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }
    public abstract void searchUser(String key, People people);
    public abstract void borrow(Library library,String wanted,Dates date,ArrayList<Log> logs);
    public abstract void read(GanjinehBook ganjinehBook, Dates date);

}

interface LibraryUser{
    public ArrayList<TakenObject> getTakenObjects();
    public int getPenalty();
    public void setPenalty(int penalty);
    public boolean isAllowed(Dates date,LibraryUser libraryUser);
}
class Student extends Person implements LibraryUser,CanComment{
    private ArrayList<TakenObject> takenObjects;
    private int penalty;
    public Student( String userId, String password, String firstName, String lastName, String nationalCode,
                   int birthYear, String Address){
        super(userId, password,firstName, lastName,nationalCode, birthYear, Address);
        takenObjects=new ArrayList<>();
        penalty=0;
    }

    public void addComment(String comment, Book book) {
        book.getComments().add(new Comment(comment));
    }
    public int getPenalty() {
        return penalty;
    }

    @Override
    public void buy(SellingBook sellingBook,Library library,ArrayList<Log> logs) {
        if(this.getPenalty()!=0){
            System.out.println("not-allowed");
            logs.add(new Log(this.getUserId(),"buy","not-allowed",library.getLibraryId(),sellingBook));
            return;
        }
        sellingBook.setBookNumber(sellingBook.getBookNumber()-1);
        sellingBook.getTakenObjects().add(new TakenObject(this.getUserId(),"student",library.getLibraryId(), sellingBook));
        System.out.println("success");
        logs.add(new Log(this.getUserId(),"buy","success",library.getLibraryId(),sellingBook));
    }
    @Override
    public ArrayList<TakenObject> getTakenObjects() {
        return takenObjects;
    }

    @Override
    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
    public void read(GanjinehBook ganjinehBook, Dates date) {
        System.out.println("permission-denied");
    }

    @Override
    public boolean isAllowed(Dates date,LibraryUser libraryUser) {
        LocalDateTime dateTime1 = LocalDateTime.of(date.getYear(), date.getMonth(),
                date.getDay(), date.getHour(), date.getMinute());
        for (TakenObject takenObject : libraryUser.getTakenObjects()) {
            LocalDateTime dateTime2 = LocalDateTime.of(takenObject.getTakenDate().getYear(), takenObject.getTakenDate().getMonth(),
                    takenObject.getTakenDate().getDay(), takenObject.getTakenDate().getHour(), takenObject.getTakenDate().getMinute());
            Duration duration = Duration.between(dateTime2, dateTime1);
            long hoursBetween = duration.toHours() ;
            if(takenObject.getTakenThesis().equals("-")){
                if(hoursBetween>10*24){
                    return false;
                }
            }
            else {
                if(hoursBetween>7*24){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void borrow(Library library,String wanted,Dates date,ArrayList<Log> logs) {
        if (this.getTakenObjects().size() == 3 || penalty!=0) {
            System.out.println("not-allowed");
            logs.add(new Log(this.getUserId(),"borrow","not-allowed",date,library.getLibraryId(),null));
            return;
        }
        if(!this.isAllowed(date, this)){
            System.out.println("not-allowed");
            logs.add(new Log(this.getUserId(),"borrow","not-allowed",date, library.getLibraryId(),null));
            return;
        }
        Publication publication = library.getPublication(wanted);
        if(publication instanceof GanjinehBook || publication instanceof SellingBook){
            System.out.println("not-allowed");
            return;
        }
        if (publication != null) {
            for (TakenObject takenObject : this.getTakenObjects()) {
                if(publication instanceof Book){
                    if (takenObject.getTakenBook().getID().equals(wanted) && takenObject.getLibraryId().equals(library.getLibraryId())) {
                        System.out.println("not-allowed");
                        logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                        return;
                    }
                }
                else {
                    if (takenObject.getTakenThesis().getID().equals(wanted)  && takenObject.getLibraryId().equals(library.getLibraryId())) {
                        System.out.println("not-allowed");
                        logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                        return;
                    }
                }
            }
            TakenObject takenObject;
            if (publication instanceof Book) {
                if (((Book) publication).getBookNumber() <= 0) {
                    System.out.println("not-allowed");
                    logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                    return;
                }
                ((Book) publication).setBookNumber(((Book) publication).getBookNumber() - 1);
                takenObject = new TakenObject(this.getUserId(), "student", library.getLibraryId(), (Book) publication, date.getYear(),
                        date.getMonth(), date.getDay(), date.getHour(), date.getMinute());
            } else {
                if (((Thesis) publication).getIsTaken()) {
                    System.out.println("not-allowed");
                    logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                    return;
                }
                ((Thesis) publication).setIsTaken(true);
                takenObject = new TakenObject(this.getUserId(), "student", library.getLibraryId(), (Thesis) publication, date.getYear(),
                        date.getMonth(), date.getDay(), date.getHour(), date.getMinute());
            }
            this.getTakenObjects().add(takenObject);
            publication.getTakenObjects().add(takenObject);
            System.out.println("success");
            logs.add(new Log(this.getUserId(),"borrow","success",date, library.getLibraryId(),publication));
            return;
        }
        System.out.println("not-found");
        logs.add(new Log(this.getUserId(),"borrow","not-found",date, library.getLibraryId(),null));
    }

    public void searchUser(String key, People people) {
        System.out.println("permission-denied");
    }
}


class Staff extends Person implements LibraryUser{
    private ArrayList<TakenObject> takenObjects;
    private int penalty;

    public Staff( String userId, String password, String firstName, String lastName, String nationalCode,
                    int birthYear, String Address){
        super(userId, password,firstName, lastName,nationalCode, birthYear, Address);
        takenObjects=new ArrayList<>();
        penalty=0;
    }

    public int getPenalty() {
        return penalty;
    }
    @Override
    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
    @Override
    public ArrayList<TakenObject> getTakenObjects() {
        return takenObjects;
    }
    public void read(GanjinehBook ganjinehBook, Dates date) {
        System.out.println("permission-denied");
    }
    @Override
    public void buy(SellingBook sellingBook,Library library,ArrayList<Log> logs) {
        if(this.getPenalty()!=0){
            System.out.println("not-allowed");
            logs.add(new Log(this.getUserId(),"buy","not-allowed",library.getLibraryId(),sellingBook));
            return;
        }
        sellingBook.setBookNumber(sellingBook.getBookNumber()-1);
        sellingBook.getTakenObjects().add(new TakenObject(this.getUserId(),"staff",library.getLibraryId(), sellingBook));
        System.out.println("success");
        logs.add(new Log(this.getUserId(),"buy","success",library.getLibraryId(),sellingBook));
    }
    @Override
    public boolean isAllowed(Dates date,LibraryUser libraryUser) {
        LocalDateTime dateTime1 = LocalDateTime.of(date.getYear(), date.getMonth(),
                date.getDay(), date.getHour(), date.getMinute());
        for (TakenObject takenObject : libraryUser.getTakenObjects()) {
            LocalDateTime dateTime2 = LocalDateTime.of(takenObject.getTakenDate().getYear(), takenObject.getTakenDate().getMonth(),
                    takenObject.getTakenDate().getDay(), takenObject.getTakenDate().getHour(), takenObject.getTakenDate().getMinute());
            Duration duration = Duration.between(dateTime2, dateTime1);
            long daysBetween = duration.toDays();
            long hoursBetween = duration.toHours() ;
            if(takenObject.getTakenThesis().equals("-")){
                if(hoursBetween>14*24){
                    return false;
                }
            }
            else {
                if(hoursBetween>10*24){
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public void searchUser(String key, People people) {
        HashSet<String> foundSet=new HashSet<>();
        for (Person person1 : people.getPersonArrayList()) {
            if (person1.getFirstName().toLowerCase().contains(key.toLowerCase()) ||
                    person1.getLastName().toLowerCase().contains(key.toLowerCase())) {
                foundSet.add(person1.getUserId());
            }
        }
        if (foundSet.size() == 0) {
            System.out.println("not-found");
        } else {
            ArrayList<String> foundRelated = new ArrayList<>(foundSet);
            foundRelated.sort(null);
            for (int i = 0; i < foundRelated.size(); i++) {
                System.out.printf("%s", foundRelated.get(i));
                if (i != foundRelated.size() - 1) System.out.printf("|");
            }
            System.out.println();
        }
    }

    @Override
    public void borrow(Library library,String wanted,Dates date,ArrayList<Log> logs) {
        if ( this.getTakenObjects().size() == 5) {
            logs.add(new Log(this.getUserId(),"borrow","not-allowed",date, library.getLibraryId(),null));
            System.out.println("not-allowed");
            return;
        }
        if(!this.isAllowed(date, this)){
            System.out.println("not-allowed");
            logs.add(new Log(this.getUserId(),"borrow","not-allowed",date, library.getLibraryId(),null));
            return;
        }
        Publication publication = library.getPublication(wanted);
        if(publication instanceof GanjinehBook || publication instanceof SellingBook){
            System.out.println("not-allowed");
            return;
        }
        if (publication != null) {
            for (TakenObject takenObject : this.getTakenObjects()) {
                if(publication instanceof Book){
                    if (takenObject.getTakenBook().getID().equals(wanted) && takenObject.getLibraryId().equals(library.getLibraryId())) {
                        System.out.println("not-allowed");
                        logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                        return;
                    }
                }
                else {
                    if (takenObject.getTakenThesis().getID().equals(wanted)  && takenObject.getLibraryId().equals(library.getLibraryId())) {
                        System.out.println("not-allowed");
                        logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                        return;
                    }
                }
            }
            TakenObject takenObject;
            if (publication instanceof Book) {
                if (((Book) publication).getBookNumber() <= 0) {
                    System.out.println("not-allowed");
                    logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                    return;
                }
                ((Book) publication).setBookNumber(((Book) publication).getBookNumber() - 1);
                takenObject = new TakenObject(this.getUserId(), "student", library.getLibraryId(), (Book) publication, date.getYear(),
                        date.getMonth(), date.getDay(), date.getHour(), date.getMinute());
            } else {
                if (((Thesis) publication).getIsTaken()) {
                    System.out.println("not-allowed");
                    logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                    return;
                }
                ((Thesis) publication).setIsTaken(true);
                takenObject = new TakenObject(this.getUserId(), "student", library.getLibraryId(), (Thesis) publication, date.getYear(),
                        date.getMonth(), date.getDay(), date.getHour(), date.getMinute());
            }
            this.getTakenObjects().add(takenObject);
            publication.getTakenObjects().add(takenObject);
            System.out.println("success");
            logs.add(new Log(this.getUserId(),"borrow","success",date, library.getLibraryId(),publication));
            return;
        }
        System.out.println("not-found");
        logs.add(new Log(this.getUserId(),"borrow","not-found",date, library.getLibraryId(),null));
    }
}

class Manager extends Person {
    private String workingLibrary;

    public Manager( String userId, String password, String firstName, String lastName, String nationalCode,
                    int birthYear, String Address,String workingLibrary){
        super(userId, password,firstName, lastName,nationalCode, birthYear, Address);
        this.workingLibrary=workingLibrary;
    }

    public String getWorkingLibrary() {
        return workingLibrary;
    }

    @Override
    public void buy(SellingBook sellingBook, Library library, ArrayList<Log> logs) {
        System.out.println("permission-denied");
        logs.add(new Log(this.getUserId(),"buy","permission-denied",library.getLibraryId(),sellingBook));
    }

    @Override
    public void searchUser(String key, People people) {
        HashSet<String> foundSet=new HashSet<>();
        for (Person person1 : people.getPersonArrayList()) {
            if (person1.getFirstName().toLowerCase().contains(key.toLowerCase()) ||
                    person1.getLastName().toLowerCase().contains(key.toLowerCase())) {
                foundSet.add(person1.getUserId());
            }
        }
        if (foundSet.size() == 0) {
            System.out.println("not-found");
        } else {
            ArrayList<String> foundRelated = new ArrayList<>(foundSet);
            foundRelated.sort(null);
            for (int i = 0; i < foundRelated.size(); i++) {
                System.out.printf("%s", foundRelated.get(i));
                if (i != foundRelated.size() - 1) System.out.printf("|");
            }
            System.out.println();
        }
    }

    @Override
    public void read(GanjinehBook ganjinehBook, Dates date) {
        System.out.println("permission-denied");
    }

    public void removeResource(Library library, String bookId, ArrayList<Log> logs){
        Iterator<Publication> it = library.getPublications().iterator();
        while (it.hasNext()) {
            Publication tempPublication = it.next();
            if (tempPublication.getID().equals(bookId)) {
                if (tempPublication.getTakenObjects().size() != 0) {
                    logs.add(new Log(this.getUserId(),"remove-resource","not-allowed"));
                    System.out.println("not-allowed");
                    return;
                }
                it.remove();
                logs.add(new Log(this.getUserId(),"remove-resource","success"));
                System.out.println("success");
                return;
            }
        }
        System.out.println("not-found");
        logs.add(new Log(this.getUserId(),"remove-resource","not-found"));
    }
    public void borrow(Library library,String wanted,Dates date,ArrayList<Log> logs){
        System.out.println("permission-denied");
        logs.add(new Log("unknown","borrow","permission-denied",date,library.getLibraryId(),null));
    }
    public void reportPassedDeadline(Library library,Dates date){
        LocalDateTime dateTime1 = LocalDateTime.of(date.getYear(), date.getMonth(),
                date.getDay(), date.getHour(), date.getMinute());
        HashSet<String> foundSet = new HashSet<>();
        for (Publication publication : library.getPublications()) {
            for (TakenObject takenObject : publication.getTakenObjects()) {
                LocalDateTime dateTime2 = LocalDateTime.of(takenObject.getTakenDate().getYear(), takenObject.getTakenDate().getMonth(),
                        takenObject.getTakenDate().getDay(), takenObject.getTakenDate().getHour(), takenObject.getTakenDate().getMinute());
                Duration duration = Duration.between(dateTime2, dateTime1);
                long hoursBetween = duration.toHours() ;
                if(publication instanceof Book){
                    if(takenObject.getUser().equals("student")){
                        if(hoursBetween>10*24){
                            foundSet.add(publication.getID());
                        }
                    }
                    else {
                        if(hoursBetween>14*24){
                            foundSet.add(publication.getID());
                        }
                    }
                }
                else {
                    if(takenObject.getUser().equals("student")){
                        if(hoursBetween>7*24){
                            foundSet.add(publication.getID());
                        }
                    }
                    else {
                        if(hoursBetween>10*24){
                            foundSet.add(publication.getID());
                        }
                    }
                }

            }
        }
        ArrayList<String> founds = new ArrayList<>(foundSet);
        if (founds.size() == 0) {
            System.out.println("none");
        } else {
            founds.sort(null);
            for (int i = 0; i < founds.size(); i++) {
                System.out.printf("%s", founds.get(i));
                if (i != founds.size() - 1) System.out.printf("|");
            }
            System.out.println();
        }
    }
    public  void libraryReport(Library library){
        int totalBooks = 0;
        int takenBooks = 0;
        int totalThesis = 0;
        int takenThesis = 0;
        int ganjinehNumber=0;
        int sellingBookNumber=0;
        for (Publication publication:library.getPublications()){
            if(publication instanceof Thesis){
                if (((Thesis) publication).isTaken) takenThesis++;
                else totalThesis++;
            }
            else if(publication instanceof GanjinehBook){
                ganjinehNumber++;
            }
            else if(publication instanceof SellingBook){
                sellingBookNumber += ((SellingBook)(publication)).getBookNumber();
            }
            else {
                totalBooks += ((Book)(publication)).getBookNumber();
                takenBooks += publication.getTakenObjects().size();
            }
        }
        System.out.println(totalBooks + " " + totalThesis + " " + takenBooks + " " + takenThesis+" "+ganjinehNumber+" "+sellingBookNumber);
    }
    public void categoryReport(Category category,Library library,Categories categoryList){
        ArrayList<Category> children=categoryList.giveChildren(category);
        int bookNumber = 0;
        int thesisNumber = 0;
        int ganjinehBookNumber=0;
        int sellingBookNumber=0;
        for (Publication publication:library.getPublications()){
            if (publication.getCategory().equals(category.getCategoryID()) || categoryList.isChild(children, publication.getCategory())) {
                if(publication instanceof Thesis){
                    if(!((Thesis) publication).isTaken)thesisNumber++;
                }
                else if(publication instanceof GanjinehBook){
                    ganjinehBookNumber+= ((GanjinehBook) publication).getBookNumber();
                }
                else if(publication instanceof SellingBook){
                    sellingBookNumber+=((SellingBook)(publication)).getBookNumber();
                }
                else {
                    bookNumber+=((Book)(publication)).getBookNumber();
                }

            }
        }
        System.out.println(bookNumber + " " + thesisNumber+" "+ganjinehBookNumber+" "+sellingBookNumber);
    }
    public void addBook(Library library,Book book){
        library.getPublications().add(book);
    }
    public void addThesis(Library library,Thesis thesis){
        library.getPublications().add(thesis);
    }
    public void addGanginehBook(Library library,GanjinehBook ganjinehBook){
        library.getPublications().add(ganjinehBook);
    }
    public void addSellingBook(Library library,SellingBook sellingBook){
        library.getPublications().add(sellingBook);
    }
}

interface CanComment{
    public void addComment(String comment,Book book);
}

class Professor extends Person implements LibraryUser ,CanComment{
    private ArrayList<TakenObject> takenObjects;
    private int penalty;

    public Professor( String userId, String password, String firstName, String lastName, String nationalCode,
                    int birthYear, String Address){
        super(userId, password,firstName, lastName,nationalCode, birthYear, Address);
        takenObjects=new ArrayList<>();
        penalty=0;
    }

    @Override
    public void addComment(String comment, Book book) {
        book.getComments().add(new Comment(comment));
    }
    @Override
    public void searchUser(String key, People people) {
        HashSet<String> foundSet=new HashSet<>();
        for (Person person1 : people.getPersonArrayList()) {
            if (person1.getFirstName().toLowerCase().contains(key.toLowerCase()) ||
                    person1.getLastName().toLowerCase().contains(key.toLowerCase())) {
                foundSet.add(person1.getUserId());
            }
        }
        if (foundSet.size() == 0) {
            System.out.println("not-found");
        } else {
            ArrayList<String> foundRelated = new ArrayList<>(foundSet);
            foundRelated.sort(null);
            for (int i = 0; i < foundRelated.size(); i++) {
                System.out.printf("%s", foundRelated.get(i));
                if (i != foundRelated.size() - 1) System.out.printf("|");
            }
            System.out.println();
        }
    }

    public int getPenalty() {
        return penalty;
    }
    @Override
    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
    @Override
    public ArrayList<TakenObject> getTakenObjects() {
        return takenObjects;
    }

    @Override
    public void buy(SellingBook sellingBook,Library library,ArrayList<Log> logs) {
        if(this.getPenalty()!=0){
            System.out.println("not-allowed");
            logs.add(new Log(this.getUserId(),"buy","not-allowed",library.getLibraryId(),sellingBook));
            return;
        }
        sellingBook.setBookNumber(sellingBook.getBookNumber()-1);
        sellingBook.getTakenObjects().add(new TakenObject(this.getUserId(),"professor",library.getLibraryId(), sellingBook));
        System.out.println("success");
        logs.add(new Log(this.getUserId(),"buy","success",library.getLibraryId(),sellingBook));
    }

    @Override
    public boolean isAllowed(Dates date,LibraryUser libraryUser) {
        LocalDateTime dateTime1 = LocalDateTime.of(date.getYear(), date.getMonth(),
                date.getDay(), date.getHour(), date.getMinute());
        for (TakenObject takenObject : libraryUser.getTakenObjects()) {
            LocalDateTime dateTime2 = LocalDateTime.of(takenObject.getTakenDate().getYear(), takenObject.getTakenDate().getMonth(),
                    takenObject.getTakenDate().getDay(), takenObject.getTakenDate().getHour(), takenObject.getTakenDate().getMinute());
            Duration duration = Duration.between(dateTime2, dateTime1);
            long hoursBetween = duration.toHours() ;
            if(takenObject.getTakenThesis().equals("-")){
                if(hoursBetween>14*24){
                    return false;
                }
            }
            else {
                if(hoursBetween>10*24){
                    return false;
                }
            }
        }
        return true;
    }
    public void read(GanjinehBook ganjinehBook, Dates date){
        if(ganjinehBook.getStartReading().getYear()!=-1) {
            LocalDateTime dateTime1 = LocalDateTime.of(date.getYear(), date.getMonth(),
                    date.getDay(), date.getHour(), date.getMinute());
            LocalDateTime dateTime2 = LocalDateTime.of(ganjinehBook.getStartReading().getYear(), ganjinehBook.getStartReading().getMonth(),
                    ganjinehBook.getStartReading().getDay(), ganjinehBook.getStartReading().getHour(),ganjinehBook.getStartReading().getMinute());
            Duration duration = Duration.between(dateTime2, dateTime1);
            long minutesBetween=duration.toMinutes();
            if(minutesBetween<2*60){
                System.out.println("not-allowed");
                return;
            }
        }
        ganjinehBook.setStartReading(new Dates(date.getYear(), date.getMonth(),
                date.getDay(), date.getHour(), date.getMinute()));
        System.out.println("success");
    }

    @Override
    public void borrow(Library library,String wanted,Dates date,ArrayList<Log> logs) {
        if ( this.getTakenObjects().size() == 5) {
            System.out.println("not-allowed");
            logs.add(new Log(this.getUserId(),"borrow","not-allowed",date, library.getLibraryId(),null));
            return;
        }
        if(!this.isAllowed(date, this)){
            System.out.println("not-allowed");
            logs.add(new Log(this.getUserId(),"borrow","not-allowed",date, library.getLibraryId(),null));
            return;
        }
        Publication publication = library.getPublication(wanted);
        if(publication instanceof GanjinehBook || publication instanceof SellingBook){
            System.out.println("not-allowed");
            return;
        }
        if (publication != null) {
            for (TakenObject takenObject : this.getTakenObjects()) {
                if(publication instanceof Book){
                    if (takenObject.getTakenBook().getID().equals(wanted) && takenObject.getLibraryId().equals(library.getLibraryId())) {
                        System.out.println("not-allowed");
                        logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                        return;
                    }
                }
                else {
                    if (takenObject.getTakenThesis().getID().equals(wanted)  && takenObject.getLibraryId().equals(library.getLibraryId())) {
                        System.out.println("not-allowed");
                        logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                        return;
                    }
                }
            }
            TakenObject takenObject;
            if (publication instanceof Book) {
                if (((Book) publication).getBookNumber() <= 0) {
                    System.out.println("not-allowed");
                    logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                    return;
                }
                ((Book) publication).setBookNumber(((Book) publication).getBookNumber() - 1);
                takenObject = new TakenObject(this.getUserId(), "student", library.getLibraryId(), (Book) publication, date.getYear(),
                        date.getMonth(), date.getDay(), date.getHour(), date.getMinute());
            } else {
                if (((Thesis) publication).getIsTaken()) {
                    System.out.println("not-allowed");
                    logs.add(new Log(this.getUserId(), "borrow", "not-allowed", date, library.getLibraryId(), publication));
                    return;
                }
                ((Thesis) publication).setIsTaken(true);
                takenObject = new TakenObject(this.getUserId(), "student", library.getLibraryId(), (Thesis) publication, date.getYear(),
                        date.getMonth(), date.getDay(), date.getHour(), date.getMinute());
            }
            this.getTakenObjects().add(takenObject);
            publication.getTakenObjects().add(takenObject);
            System.out.println("success");
            logs.add(new Log(this.getUserId(),"borrow","success",date, library.getLibraryId(),publication));
            return;
        }
        System.out.println("not-found");
        logs.add(new Log(this.getUserId(),"borrow","not-found",date, library.getLibraryId(),null));
    }
}

class TakenObject {
    private String takerId;
    private String user;//Student or personnel
    private Dates takenDates;
    private Book takenBook;
    private Thesis takenThesis;
    private String libraryId;
    private SellingBook takenSellingBook;

    public TakenObject(String takerId, String user, String libraryId, Book book, int year, int month, int day, int hour, int minute) {
        this.takerId = takerId;
        this.user = user;
        this.takenDates = new Dates(year, month, day, hour, minute);
        takenBook = book;
        takenThesis = new Thesis("-","-","-","-",-1,"-"
        ,"-");
        takenSellingBook=new SellingBook("-","-","-","-",-1,-1,-1,-1,"-","-");
        this.libraryId = libraryId;
    }

    public TakenObject(String takerId, String user, String libraryId, Thesis thesis, int year, int month, int day, int hour, int minute) {
        this.takerId = takerId;
        this.user = user;
        this.takenDates = new Dates(year, month, day, hour, minute);
        this.takenThesis = thesis;
        takenBook = new Book("-","-","-","-",-1,-1
                ,"-","");
        this.libraryId = libraryId;
        takenSellingBook=new SellingBook("-","-","-","-",-1,-1,-1,-1,"-","-");

    }
    public TakenObject(String takerId, String user, String libraryId, SellingBook sellingBook) {
        this.takerId = takerId;
        this.user = user;
        this.takenDates = null;
        takenThesis = new Thesis("-","-","-","-",-1,"-"
                ,"-");
        takenBook = new Book("-","-","-","-",-1,-1
                ,"-","");
        this.libraryId = libraryId;
        this.takenSellingBook=sellingBook;
    }

    public String getTakerId() {
        return takerId;
    }

    public Book getTakenBook() {
        return takenBook;
    }

    public Thesis getTakenThesis() {
        return takenThesis;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public Dates getTakenDate() {
        return takenDates;
    }

    public String getUser() {
        return user;
    }

    public SellingBook getTakenSellingBook() {
        return takenSellingBook;
    }
}


class ReservedSeat{
    private String userId;
    private String libraryId;
    private Dates dates;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    public ReservedSeat(String userId,String libraryId,Dates dates,int startHour,int startMinute,int endHour,int endMinute){
        this.userId=userId;
        this.libraryId=libraryId;
        this.dates=dates;
        this.startHour=startHour;
        this.startMinute=startMinute;
        this.endHour=endHour;
        this.endMinute=endMinute;
    }
    public String getUserId() {
        return userId;
    }

    public Dates getDates() {
        return dates;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }
}
