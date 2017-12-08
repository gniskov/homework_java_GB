/**
 * Java. Level1. Lesson5. homework 
 * @author  Gennady Niskovskikh
 * @version 08.12.17
 * @link https://github.com/gniskov/homework_java_GB
 *
*/

public class Lesson5{

    public static void main(String[] args) {

        Associate[] arrayAs = new Associate[5];
        arrayAs[0] = new Associate("Petr Kuznetcov", "Enginer", "pkuzn@mail.ru", "+79034458765", 57000, 30);
        arrayAs[1] = new Associate("Semen Ivanov", "Manager", "sivanov@mail.ru", "+79022258765", 35000, 29);
        arrayAs[2] = new Associate("Ivan Korolev", "Driver", "ikorol@mail.ru", "+79034338765", 25000, 44);
        arrayAs[3] = new Associate("Georgy Sizov", "Enginer", "gsizov@mail.ru", "+79034988765", 55000, 51);
        arrayAs[4] = new Associate("Ilya Kuzovenkov", "Enginer", "ikuzov@mail.ru", "+79030758765", 47000, 25);
        //System.out.println(arrayAs[1].name + " " + arrayAs[1].age);
        
        for(int i=0;i<arrayAs.length;i++) {
            if(arrayAs[i].age>40) {
                arrayAs[i].method();
                System.out.println("Next:*************");
            }
        }
    }
}

class Associate {

    String name;
    String position;
    String email;
    String phone;
    int age;
    int pay;

    Associate(String name, String position, String email, String  phone,int pay, int age) {

        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.pay = pay;
        System.out.println(name+ " " + email +" "+ position);
    }

    void method() {

        System.out.println("Name is - " + " " + name);
        System.out.println("E-mail is - " + " " + email);
        System.out.println("Position is - " + " " + position);
        System.out.println("Age is - " + " " + age);
        System.out.println("Pay is - " + " " + pay);
        System.out.println("Phone is - " + " " + phone);
    }
}

