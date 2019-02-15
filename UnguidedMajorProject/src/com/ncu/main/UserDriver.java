package com.ncu.main;
import com.ncu.classdefinitions.*;
import java.io.*;
import java.util.*;
import com.ncu.validators.*;
import com.ncu.exceptions.*;
public class UserDriver{
	public static void main(String[] args){
		int ch, c, cnt=0;
		File f2;
		String name;
		String pass;
		NameValidator z = new NameValidator();
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
				int flag = 1;
				boolean v = true;
				boolean h = false;
				try{
				f2 = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\userinfo\\users.txt");
					Scanner inputStream = new Scanner(f2);
		        while(inputStream.hasNextLine()){
		        	cnt++;
		        }
		        inputStream.close();

		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		    do{
				System.out.println("Enter username: " + "\n");
				name = sc.nextLine();
				System.out.println("Enter password: " + "\n");
				pass = sc.nextLine();
				v = z.nameValidator(name, pass);
				if(v==true)
					flag = 0;
				if(v==false){
					System.out.println("Enter any key to try again or 0 to go back to Main Menu: " + "\n");
					flag = sc.nextInt();
				}
			}while(flag!=0);
			if(v==false)
				break;
				User x = new User(name, pass, cnt);
				h = x.SearchU(name);
				if(h==false){
				u[cnt] = new User(name, pass, cnt);
				try{
			    f2 = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\userinfo\\users.txt");
				FileWriter fout = new FileWriter(f2,true);
				BufferedWriter bout = new BufferedWriter(fout);
				bout.write((cnt+1) + "." + name + "   " + pass);
				bout.newLine();
				u[cnt].Create(cnt);
				bout.close();
			} catch(Exception e){
			e.printStackTrace();
		}
		}
		
			if(h==true){
				System.out.println("The username is already in use. Pick another username or login if you already have an account" + "\n");
			}


			}
			break;
			case 2 : {
				boolean w = true;
				int n;
				int ind=1;
				int a, o, i=0;
				String t;
				String p;
				boolean h = true;
				do{
				System.out.println("Enter username: " + "\n");
				name = sc.nextLine();
				System.out.println("Enter password: " + "\n");
				pass = sc.nextLine();
				w = z.nameValidator(name, pass);
				if(w==false){
					System.out.println("Enter any key to try again or 0 to go back to Main Menu: " + "\n");
					ind = sc.nextInt();
				}

			}while(ind!=0);
			if(w==false)
				break;
				try{
				f2 = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\userinfo\\users.txt");
			    Scanner inputStream = new Scanner(f2);
				while(inputStream.hasNextLine()){
		            String sr;
		            sr = inputStream.nextLine();
		            for(a=0;a<sr.length();a++){
		            	if(sr.charAt(a)==' '){
		            		a--;
		            		break;
		            	}
		            	

		            }
		            t = new String(sr.substring(2,a));
		            o = (a+3);
		            p = new String(sr.substring(o,(sr.length()-1)));
		            u[i] = new User(t, p, i);
		            i++;
		        }
		        inputStream.close();
		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		        for(o=0;o<=i;o++){
		        	h = u[o].Search(name, pass);
		        	if(h==true){
		        		n = o;
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
		        		break;
		        	}
		        }
		        if(h==false){
		        	System.out.println("Incorrect  username or password. Try again" + "\n");
		        }
		        

			}
			break;
			default : System.out.println("Invalid choice" + "\n");

		}
		System.out.println("Enter 0 to exit or any other key to go back to Main Menu: " + "\n");
		key = sc.nextInt();
	}while(key!=0);


	}
}