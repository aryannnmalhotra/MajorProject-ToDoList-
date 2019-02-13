package com.ncu.classdefinitions;
import java.util.*;
import java.io.*;
import java.io.File;
public class User{
	String userName;
	String password;
	File f;
	User(){
		userName = "";
		password = "";
		f = null;
	}
	User(String userName, String password){
		this.userName = userName;
		this.password = password;
		this.f = new File("C:\\JAVAFOCP2\\UnguidedMajorProject\\todofiles\\todo.txt");
	}
	void Display(){
		try{
		f = new File("C:\\JAVAFOCP2\\UnguidedMajorProject\\todofiles\\todo.txt");	
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
	void Create(){
		int i = 0;
		char ans;
			try{
				f = new File("C:\\JAVAFOCP2\\UnguidedMajorProject\\todofiles\\todo.txt");
				FileWriter fout =  new FileWriter(f);
				BufferedWriter bout = new BufferedWriter(fout);
				do{
					Scanner sc = new Scanner(System.in);
				    System.out.println("Enter the task: " + "\n");
					bout.write((++i) + "." + sc.nextLine());
					bout.newLine();
					System.out.println("Do you want to add another task? Enter Q to exit" + "\n");
					ans = sc.next().charAt(0); 

                } while(ans!='Q' || ans!='q');
                bout.close();			
            }

		
		catch(Exception e){
			e.printStackTrace();
		}
	} void Delete(int k){
		int i=0;
		Scanner sc = new Scanner(System.in);
		try{
		File f1 = new File("C:\\JAVAFOCP2\\UnguidedMajorProject\\todofiles\\temp.txt");
		f = new File("C:\\JAVAFOCP2\\UnguidedMajorProject\\todofiles\\todo.txt");
		FileWriter fout =  new FileWriter(f1);
		BufferedWriter bout = new BufferedWriter(fout);
		FileReader fin = new FileReader(f);
		BufferedReader bin = new BufferedReader(fin);
		while(sc.hasNext()){
			i++;
			if(i!=k){
				 bout.write(bin.readLine()); 
				 bout.newLine();
                
			}
		}
		bout.close();
		bin.close();
		f1.renameTo(f);
		f.delete();
      }
      catch(Exception e){
      	e.printStackTrace();
      }
	
	}
	void Update(int k){
		int i = 0;
		try{
		File f1 = new File("C:\\JAVAFOCP2\\UnguidedMajorProject\\todofiles\\temp.txt");
		FileWriter fout =  new FileWriter(f1);
		BufferedWriter bout = new BufferedWriter(fout);
		f = new File("C:\\JAVAFOCP2\\UnguidedMajorProject\\todofiles\\todo.txt");
		FileReader fin = new FileReader(f);
		BufferedReader bin = new BufferedReader(fin);
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
            ++i;
            if(i!=k){
            	bout.write(bin.readLine());
                bout.newLine();
            }    
            else{
            	System.out.println("Update the said task: " + "\n");
            	bout.write((k) + "." + sc.nextLine());
			    bout.newLine();

            }

		}
		bout.close();
		bin.close();
		f1.renameTo(f);
		f.delete();
	}
	catch(Exception e){
		e.printStackTrace();
	}

}
 void Add(){
 	
 }
	
          
}


