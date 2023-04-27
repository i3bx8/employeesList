

import java.util.Scanner;

public class DSProject {
    /*Done by : 1- Abdullah Aljadani 2140458 2- Shali Aljadani 2142741 3- Khalid Adel 2141925*/
 private Node head;
 private  class Node{
          
 private int ID;
 private String name;
 private String Fday;
 private String phoneNum;
 private String address;
 private double hours;
 private double salary;
 private Node next;
        
    public Node(int ID,String name,String day,String phoneNum,String address,double hours,double salary){
            this.ID=ID;
            this.name=name;
            this.Fday=day;
            this.phoneNum=phoneNum;
            this.address=address;
            this.hours=hours;
            this.salary=salary;
            this.next=null;
        }
    }
    
   public void insertEmp(int ID,String name,String day,String phoneNum,String address,double hours,double salary){
       
       if(!check_Record(ID)){ 
           
           
       Node Nnode=new Node(ID,name,day,phoneNum,address,hours,salary);
       
        if(head==null)
        {
            head=Nnode;
            return;
        }
        
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=Nnode;
       }
       
       else{
           System.out.println("This ID: "+ID+ " is ALREADY EXIST!! ");
       }
    }
   boolean check_Record(int ID)
   {
       Node temp=head;
       
       if(head==null)
           return false;
       
        while(temp!=null&&head!=null)
        {
            if(temp.ID==ID)
                return true;
            temp=temp.next;
        }
       return false;
   }
   
   public void search_Record(int ID){
      Node temp=head;
        while (temp!= null) {
              if(temp.ID == ID){
                System.out.println("Employee Info :\n- ID:"+ID+"\n- Name:"+temp.name+"\n- First day of work: "+
                        temp.Fday+"\n- Phone number: "+temp.phoneNum+"\n- Address :"+temp.address+"\n- Work hours: "+temp.hours
                +"\n- Salary: "+temp.salary);
               return;
            }else{
                temp=temp.next;
            }
        }
        System.out.println("employee with ID ("+ID+") not registered" );
   }
   
   
     public  int delEmp(int ID){
         
  Node temp=head,prev=null;
         
  if (temp != null && temp.ID == ID) 
   {
      head = temp.next; 
      return 1;
    }
  while (temp != null && temp.ID != ID) 
    {
      prev = temp;
      temp = temp.next;
     }
 if(temp==null)
    {
       return 0;
    }
     prev.next=temp.next;
      return 1;
   }
     public void show_Record(){
        Node temp=head;
        while(temp!=null){
       System.out.println("Employee Information :\n- ID:"+temp.ID
                          +"\n- Name:"+temp.name
                          +"\n- First day of work: "+temp.Fday
                          +"\n- Phone number: "+temp.phoneNum   
                          +"\n- Address :"+temp.address 
                          +"\n- Work hours: "+temp.hours
                          +"\n- Salary: "+temp.salary);
         temp=temp.next;
        }
    
     }
     public void update_Salary()
     {
        
         if(head==null)
         {
             return;
         }
          
         Node temp=head;
        while(temp!=null){
            if(temp.hours>32){
                temp.salary+=(temp.salary*0.02);
            
            }
            temp=temp.next;
        }
         System.out.println("The record has been UPDATED");
     }
     
     
     public void update_Emp(int ID){
         if(!check_Record(ID)){
             System.out.println("This ID doesn't found");
         }else{
             
    Scanner scan=new Scanner(System.in);
    String name,day,phoneNum,address;
    double hours,salary;
        System.out.print("please enter the new employee NAME:");  
                        name=scan.nextLine();
        System.out.print("please enter the new FIRST DAY of work:");  
                        day=scan.nextLine();
        System.out.print("please enter the new PHONE NUMBER:");  
                        phoneNum=scan.nextLine();
        System.out.print("please enter the new Address:");  
                        address=scan.nextLine();
        System.out.print("please enter the new Work hours:");  
                        hours=scan.nextDouble();
        System.out.print("please enter the new Salary:");  
                        salary=scan.nextDouble();
              Node temp=head;
                while(temp!=null)
                {
                    if(temp.ID==ID)
                    {
                          temp.name=name;
                          temp.salary=salary;
                          temp.address=address;
                          temp.Fday=day;
                          temp.hours=hours;
                          temp.phoneNum=phoneNum;
                    }
                    temp=temp.next;
                }
         }
         
     }
      public static void main(String[] args) {
            Scanner scan=new Scanner(System.in);
            int choice;
            int ID;
            String name;
            String Fday;
            String phoneNum;
            String address;
            double hours;
            double salary;
            boolean repeat=true;
            DSProject emp=new DSProject();
           
           while(repeat){
                System.out.println("********************************\n"+
                                   "please Select your choice \n"+
                                   "********************************\n"+
                                     "To INSERT employee record select (1)\n" +
                                      "To UPDATE employee record select (2)\n"+
                                       "To DELETE employee record select (3)\n" +
                                       "To SEARCH employee select (4)\n"+
                                       "To SHOW employee select (5)\n" +
                                       "To UPDATE salary select (6)\n"+
                                       "To EXIT select (7)\n"+
                                       "********************************\n"+
                                       "your choice: " );
                choice=scan.nextInt();
                switch(choice){
                    case 1:
                        
                        System.out.print("Enter employee ID:");  
                        ID=scan.nextInt();
                        scan.nextLine();
                        System.out.print("Enter employee NAME:");  
                        name=scan.nextLine();
                        System.out.print("Enter FIRST DAY of work:");  
                        Fday=scan.nextLine();
                        System.out.print("Enter PHONE NUMBER:");  
                        phoneNum=scan.nextLine();
                        System.out.print("Enter ADDRESS:");  
                        address=scan.nextLine();
                        System.out.print("Enter WORK HOURS:");  
                        hours=scan.nextDouble();
                        System.out.print("Enter SALARY:");  
                        salary=scan.nextDouble();
                        emp.insertEmp(ID, name, Fday, phoneNum, address, hours, salary);
                        
                      break;
                      
                       case 2:
                         System.out.println("Enter the employee ID to UPDATE :");
                         ID=scan.nextInt();
                         emp.update_Emp(ID);
                        break;
                    case 3: 
                        
                        System.out.println("Enter the ID to delete employee :");
                        ID=scan.nextInt();
                        if(emp.delEmp(ID)==1){
                            System.out.println("Has been Deleted successfully");
                            
                        }else{
                            System.out.println("This ID: "+ID+ " is DOESN'T EXIST! ");
                        }
                        break;
                    
                    case 4:
                        System.out.println("Enter the employee ID to SEARCH :");
                        ID=scan.nextInt();
                        emp.search_Record(ID);
                        break;
                    case 5:
                        emp.show_Record();
                        break;
                    
                    case 6:
                        emp.update_Salary();
                        break;
                    case 7:
                        repeat=false;
                        break;
                    default:
                        System.out.println("Wrong choice");
                        
                        
                }
           }
            
      
    }
    
}