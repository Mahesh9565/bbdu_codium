import java.util.Scanner;
class Account
{
int bal;
Account(int b)
{
bal=b;
}
Boolean isSufficientBal(int w)
{
if(bal>w)
return true;
else
return false;
}
public void withdraw(int wb)
{
bal=bal-wb;
System.out.println("withdraw successful");
System.out.println("current bal is:"+bal);
}
}

class customer implements Runnable
{
Account h1;
String name;
customer(Account g1,String s1)
{
h1=g1;
name=s1;
}
public void run()
{
synchronized(h1)
{
Scanner s1=new Scanner(System.in);
System.out.println(name+" enter amount to withdraw ");
int amt=s1.nextInt();
if(h1.isSufficientBal(amt))
{
System.out.println(name+" ");
h1.withdraw(amt);
}
else
{
System.out.println(name+" inSufficientBal");
}
}
}
}
class MultiT3
{
public static void main(String[]args)
{
Account a1=new Account(2000);
customer c1=new customer(a1,"payal");
customer c2=new customer(a1,"radha");
Thread t1=new Thread(c1);
Thread t2=new Thread(c1);
t1.start();
t2.start();
}
}
