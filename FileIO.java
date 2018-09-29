import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	
	static int N = 0; //number of data(city) in file
	TourManager tmanager = new TourManager();

	
	public void readFile(String filename){
		
		try{
	        	File file=new File(filename);
	        	FileReader filereader=new FileReader(file);
	        	BufferedReader bufReader = new BufferedReader(filereader);
	        	String line=""; int cnt=0;
	        	
	        	//set N: number of data
	        	while((line=bufReader.readLine())!=null){
	        		cnt++;
	        		if(cnt==6){
	        			int idx = line.indexOf(":");
	        			String temp = line.substring(idx + 2);
	        			N = Integer.parseInt(temp);
	        		}
	        		if(cnt == 8) break;
	        	}
	        	
	        	// read city data
	        	cnt=0;
	        	while((line=bufReader.readLine())!=null){
	        		cnt++;
	        		// parse line: [id x_pos y_pos]
	        		String temp[]=line.split(" ");
	        		int tid=Integer.parseInt(temp[0]);
	        		int tx=Integer.parseInt(temp[1]);
	        		int ty=Integer.parseInt(temp[2]);
	        		
	        		tmanager.addCity(new City(tid, tx, ty));
	        		
	        		if(cnt == N) break;
	        	}
	        }catch(FileNotFoundException e){
	        	//TODO: handle exception
	        }catch(IOException e){
	        	System.out.println(e);
	        }
		 
	}//method: readFile END
	
	public void writeFile(){
		int numCity = tmanager.numOfCities();
		
		//write result to output
        try{
        	File file = new File("res/output.txt");
        	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        	
        	if(file.isFile() && file.canWrite()) {        		
        		for(int i = 0; i < numCity; i++) {
        			bufferedWriter.write(Integer.toString(tmanager.getCity(i).getID()));
        			bufferedWriter.newLine();
        		}
        		bufferedWriter.close();
        	}
        	
        }catch(IOException e) {
        	e.printStackTrace();
        	System.out.println(e);
        }
	}//method: writeFile END
	
}
