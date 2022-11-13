package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Notifications {
	
	public static boolean checkValidIDStudent(String id) {
		try {
			FileReader fr = new FileReader("StudentIDs.txt");
	        BufferedReader br = new BufferedReader(fr);
	        String line;
	        
	        while ((line = br.readLine()) != null) {
	            if (line.contains(id)) {
	            	br.close();
	            	return true;
	            }
	        }
	        br.close();
	        return false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean checkValidIDChef(String id) {
		try {
			FileReader fr = new FileReader("ChefIDs.txt");
	        BufferedReader br = new BufferedReader(fr);
	        String line;
	        
	        while ((line = br.readLine()) != null) {
	            if (line.contains(id)) {
	            	br.close();
	            	return true;
	            }
	        }
	        br.close();
	        return false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean checkValidIDProcessingAgent(String id) {
		try {
			FileReader fr = new FileReader("ProcessingAgentIDs.txt");
	        BufferedReader br = new BufferedReader(fr);
	        String line;
	        
	        while ((line = br.readLine()) != null) {
	            if (line.contains(id)) {
	            	br.close();
	            	return true;
	            }
	        }
	        br.close();
	        return false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void writeOrder(Order order) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("OrderList.txt"));
	        oos.writeObject(order);
	        //oos.flush();
	        oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*String input = order.toString();
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("acceptedOrders.txt"));
		    out.write(input); 
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} */
	}
	
	public ArrayList<Order> readFile(String file) {
		ArrayList<Order> ret = new ArrayList<Order>();
		boolean cont = true;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("outputFile"));
            while(cont){
            	Order obj = null;
                try {
                	obj = (Order) ois.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                  if(obj != null)
                     ret.add(obj);
                  else
                     cont = false;
               }
            ois.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
