package com.ncu.main;
import com.ncu.classdefinitions.*;
import java.io.*;
import java.util.*;
public class UserDriver{
	public static void main(String[] args){
		int ch, c, cnt=0;
		File f2;
		String name;
		String pass;
		User u[] = new User[200];
		Scanner sc = new Scanner(System.in);
		int key;
		do{
		System.out.println("Select from Main Menu: " + "\n");
		System.out.println("1.Create user: " + "\n");
		System.out.println("2.Login and update a user record: " + "\n");
		ch = sc.nextInt();
		switch(ch){
			case 1 : {
				f2 = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\userinfo\\users.txt");
					Scanner inputStream = new Scanner(f2);
		        while(inputStream.hasNextLine()){
		        	cnt++;
		        }
		        inputStream.close();
				System.out.println("Enter username: " + "\n");
				name = sc.nextLine();
				System.out.println("Enter password: " + "\n");
				pass = sc.nextLine();
				u[cnt] = new User(name, pass, cnt);
				FileWriter fout = new FileWriter(f2,true);
				BufferedWriter bout = new BufferedWriter(fout);
				bout.write(cnt + "." + name + "   " + pass);
				bout.newLine();
				u[cnt].Create(cnt);
				bout.close();

			}
			break;
			case 2 : {
				int n;
				int a, o, i=0;
				String t;
				String p;
				System.out.println("Enter username: " + "\n");
				name = sc.nextLine();
				System.out.println("Enter password: " + "\n");
				pass = sc.nextLine();
				f2 = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\userinfo\\users.txt");
			    Scanner inputStream = new Scanner(f2);
				while(inputStream.hasNextLine()){
		            String sr;
		            sr = inputStream.nextLine();
		            for(a=0;a<sr.length();a++){
		            	if(sr.charAt(a)==' '){
		            		a--;
		            	}
		            	break;

		            }
		            t = new String(sr.substring(2,a));
		            o = (a+3);
		            p = new String(sr.substring(o,(sr.length()-1)));
		            u[i] = new User(t, p, i);
		            i++;
		        }
		        inputStream.close();
		        for(o=0;o<=i;o++){
		        	boolean h = u[i].Search(name, pass);
		        	if(h==true){
		        		n = i;
		        		break;
		        	}
		        }
		        int skey;
				do{
				System.out.println("Select from Operations Menu: " + "\n");
				System.out.println("1.Display to-do list: " + "\n");
				System.out.println("2.Add tasks to to-do list: " + "\n");
				System.out.println("3.Update/Modify contents of to-do list: " + "\n");
				System.out.println("4.Delete a task from to-do list: " + "\n");
				c = sc.nextInt();
				switch(c){
					case 1 : u[n].Display(n); 
					break;
					case 2 : u[n].Add(n);
					break;
					case 3 : {
						u[n].Display(n);
						System.out.println("Enter the task number that you want to modify/update: " + "\n");
                        int k = sc.nextInt();
						u[n].Update(n,k);
					}
					break;
					case 4 : {
						u[n].Display(n);
						System.out.println("Enter the task number that you want to remove from the to-do list: " + "\n");
						int k = sc.nextInt();
						u[n].Delete(n,k);
					}
					break;
					default : System.out.println("Invalid choice" + "\n");
				}
				System.out.println("Enter 0 to exit Operations Menu or any other key to go back to Operations Menu:  " + "\n");
				skey = sc.nextInt();
			}while(skey!=0);

			}
			default : System.out.println("Invalid choice" + "\n");

		}
		System.out.println("Enter 0 to exit or any other key to go back to Main Menu: " + "\n");
		key = sc.nextInt();
	}while(key!=0);


	}
}