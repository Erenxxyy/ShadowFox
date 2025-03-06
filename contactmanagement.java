import java.util.ArrayList;
import java.util.Scanner;

class contact
{
    ArrayList<String> Names = new ArrayList<>();
    ArrayList<String> Email  = new ArrayList<>();
    ArrayList<Long> Numbers = new ArrayList<>();

     public void addcontact(Scanner sc)
     {
        System.out.println(" \n Enter phone number ");
        long contacts=sc.nextLong();
        sc.nextLine();
        if (String.valueOf(contacts).length() < 10) {
            System.out.println(" \n Number Atleast 10 digit");
            return;
        }
        System.out.println("\n Enter the name ");
         String name =sc.nextLine();
         System.out.println(" \n Enter Email ");
         String email=sc.next();


           Names.add(name);
           Email.add(email);
           Numbers.add(contacts);

           System.out.println("Add Succesfully.... \n ");

         
    }
    public void viewcontact(Scanner sc){
        if(Numbers.isEmpty()){
            System.out.println(" \n No contact !!");
        }
        else{
            System.out.println("\n List Contact ");
            for (int i =0 ;i<Numbers.size();i++){
                System.out.println("Name :" + Names.get(i));
                System.out.println("Email :"+ Email.get(i));
                System.out.println("Contact :" +Numbers.get(i));
                System.out.println("------------------");
            }
        }
    }
    public void Updatecontact(Scanner sc){
        System.out.println("Which Contact to update " );
        Long contacts = sc.nextLong();
        sc.nextLine();

        if(!Numbers.contains(contacts)){
            System.out.println("Not found !!");
        }
        else{
            int index = Numbers.indexOf(contacts);

        System.out.println(" New name : ");
        Names.set(index, sc.nextLine());
    
        System.out.println(" New email : ");
        Email.set(index, sc.next());
    
        System.out.println("Contact updated successfully...!\n");
        }
        }
        public void deletecontact(Scanner sc){
            System.out.println("Enter the number to delete");
            Long contact = sc.nextLong();
            sc.nextLine();

            if(!Numbers.contains(contact)){
                System.out.println("\n Not Found ");
            }
            else{
                int index = Numbers.indexOf(contact);

                Numbers.remove(index);
                Names.remove(index);
                Email.remove(index);
                
                System.out.println(" \n Deleted !!!");
            }          
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        contact ad = new contact();
        while(true){
            System.out.print("\n Add contact  ");
            System.out.print("\n View contact  ");
            System.out.print("\n Update contact ");
            System.out.print("\n Delete contact  ");
            System.out.print("\n Enter your choice : ");
            int choice=sc.nextInt();
     if(choice == 1 || choice == 2 || choice == 3 || choice == 4){
          if (choice == 1){
            ad.addcontact(sc);
          } 
          if (choice == 2){
            ad.viewcontact(sc);                     
        }
         if (choice == 3){
            ad.Updatecontact(sc);
         }
        if (choice == 4){
                ad.deletecontact(sc);  
        }
    }
    else{
        System.out.println(" \n INVALID OPTION");
    }
    
}
}
}