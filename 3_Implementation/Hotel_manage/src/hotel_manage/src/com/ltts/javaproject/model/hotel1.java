package com.ltts.javaproject.model;

import java.util.*;

interface hotel
{
void show();
}

class booking implements hotel
{
int n=0;

booking()
{
Scanner sc = new Scanner(System.in);
System.out.println("\n**Welcome To Our Hotel**\n\n");
while(true)
{
System.out.println("\nEnter number of customers:");
try
{
n=sc.nextInt();
if(n<1)
{
throw new ArithmeticException();
}
break;
}
catch(ArithmeticException e)
{
System.out.print("\nNumber of customers should be atleast 1");
}
}

}
String name=new String();
String age=new String();
String gender=new String();
String pno=new String();
String check_in = new String();
String cin_time= new String();
String check_out= new String();
String cout_time= new String();
void getdata()
{
Scanner sc = new Scanner(System.in);
int i=0;
System.out.print("\nEnter check-in date(dd/mm/yyyy) :");
check_in=sc.nextLine();
System.out.print("\nEnter check-in time(hh:mm am/pm) :");
cin_time=sc.nextLine();

System.out.print("\nEnter check-out date(dd/mm/yyyy) :");
check_out=sc.nextLine();
System.out.print("\nEnter check-out time(hh:mm am/pm) :");
cout_time=sc.nextLine();
int j=0;
for(i=0;i<n;i++)
{
System.out.print("\nEnter Name of Customer ");
name=sc.nextLine();
System.out.print("\nEnter age of Customer ");
age=sc.nextLine();
System.out.print("\nEnter gender(m / f) of Customer ");
gender=sc.nextLine();
System.out.print("\nEnter mobile number of Customer ");
pno=sc.nextLine();
try
{
	if(pno.length()<10)
		throw new ArithmeticException();

}
catch(ArithmeticException e)
{
System.out.print("\nPlz enter a valid  mobile no ");
}
}

}
public void show()
{
int i=0;
System.out.print("\nNumber Of Customers : "+n);
System.out.print("\n Check in date : "+check_in);
System.out.print("\n Check in time : "+cin_time);
System.out.print("\n Check out date : "+check_out);
System.out.print("\n Check out time : "+cout_time);
for(i=0;i<n;i++)
{
System.out.print("\n Customer "+(i+1)+":");
System.out.print("\n Name : "+name);
System.out.print("\n Age : "+age);
System.out.print("\n Gender : "+gender);
System.out.print("\n Mobile Number : "+pno);
}
}
}
