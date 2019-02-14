package com.ncu.classdefinitions;
import java.util.*;
import java.io.*;
import java.io.File;
public class User{
	public String userName;
	public String password;
	File f;
	public User(){
		userName = "";
		password = "";
		f = null;
	}
	public User(String userName, String password, int i){
		this.userName = userName;
		this.password = password;
		String fileName = new String("todo"+i+".txt");
		this.f = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\todofiles\\" + fileName);
	}
	public void Display(int i){
		String fileName = new String("todo"+i+".txt");
		try{
		f = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\todofiles\\" + fileName);	
		FileReader fin = new FileReader(f);
		BufferedReader bin = new BufferedReader(fin);
		String sr;
		System.out.println("Your to-do list is as follows:" + "\n");
		while((sr=bin.readLine())!=null){
			System.out.println(sr);
		}
	}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public void Create(int j){
		String fileName = new String("todo"+j+".txt");
		int i=0;
		int ans;
			try{
				f = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\todofiles\\" + fileName);
				FileWriter fout =  new FileWriter(f);
				BufferedWriter bout = new BufferedWriter(fout);
				do{
					Scanner sc = new Scanner(System.in);
				    System.out.println("Enter the task: " + "\n");
					bout.write((++i) + "." + sc.nextLine());
					bout.newLine();
					System.out.println("Do you want to add another task? Enter 0 to exit or any other key to continue: " + "\n");
					ans = sc.nextInt(); 

                } while(ans!=0);
                bout.close();			
            }

		
		catch(Exception e){
			e.printStackTrace();
		}
	} 
	public void Delete(int j, int k){
		String fileName = new String("todo"+j+".txt");
		int i=0;
		Scanner sc = new Scanner(System.in);
		try{
		File f1 = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\todofiles\\temp.txt");
		f = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\todofiles\\" + fileName);
		FileWriter fout =  new FileWriter(f1);
		BufferedWriter bout = new BufferedWriter(fout);
		Scanner inputStream = new Scanner(f);
		while(inputStream.hasNextLine()){
			i++;
			if(i!=k){
				 bout.write(inputStream.nextLine()); 
				 bout.newLine();
                
			}
		}
		bout.close();
		inputStream.close();
		f.delete();
		f1.renameTo(f);
      }
      catch(Exception e){
      	e.printStackTrace();
      }
	
	}
	public void Update(int j, int k){
		String fileName = new String("todo"+j+".txt");
		int i = 0;
		try{
		File f1 = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\todofiles\\temp.txt");
		FileWriter fout =  new FileWriter(f1);
		BufferedWriter bout = new BufferedWriter(fout);
		f = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\todofiles\\" + fileName);
		Scanner inputStream = new Scanner(f);
		Scanner sc = new Scanner(System.in);
		while(inputStream.hasNextLine()){
            ++i;
            if(i!=k){
            	bout.write(inputStream.nextLine());
                bout.newLine();
            }    
            else{
            	System.out.println("Update the said task: " + "\n");
            	bout.write((k) + "." + sc.nextLine());
			    bout.newLine();

            }

		}
		bout.close();
		inputStream.close();
		f.delete();
		f1.renameTo(f);
	}
	catch(Exception e){
		e.printStackTrace();
	}

}
 public void Add(int j){
 	String fileName = new String("todo"+j+".txt");
 	int i=0;
	int ans;
			try{
				f = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\todofiles\\" + fileName);
				FileWriter fout =  new FileWriter(f,true);
				BufferedWriter bout = new BufferedWriter(fout);
				do{
					Scanner sc = new Scanner(System.in);
				    System.out.println("Enter the task: " + "\n");
					bout.write((++i) + "." + sc.nextLine());
					bout.newLine();
					System.out.println("Do you want to add another task? Enter 0 to exit or any other key to continue: " + "\n");
					ans = sc.nextInt();

                } while(ans!=0);
                bout.close();			
            }

		
		catch(Exception e){
			e.printStackTrace();
		}
 	
 }
  public boolean Search(String userName, String password){
 	boolean res = false;
 	String n;
 	String p;
 	int o, a;
 	File f2 = new File("C:\\Users\\Apoorva Malhotra\\MajorProject-ToDoList-\\UnguidedMajorProject\\userinfo\\users.txt");
 	try{
    	Scanner inputStream = new Scanner(f2);
    	while(inputStream.hasNextLine()){
    	String sr = inputStream.nextLine();
    	for(a=0;a<sr.length();a++){
		            	if(sr.charAt(a)==' '){
		            		a--;
		                    break;
		                }

		            }
		            n = new String(sr.substring(2,a));
		            o = (a+3);
		            p = new String(sr.substring(o,(sr.length()-1)));
		            boolean res1 = n.equals(this.userName);
		            boolean res2 = p.equals(this.password);
		            if(res1==true && res2==true){
		                 res = true;
		                 break;
		            }
		        } inputStream.close();
    } catch(Exception e){
    	e.printStackTrace();
    }
    return res;

 }
}
	
          



