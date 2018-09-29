/*

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	//static int N; //number of data
    
    public static void main(String[] args) {
        Random mRandom = new Random();                  // ����Ʈ������ ���� �����Լ�
        DescDistance mDistance = new DescDistance();    // ��� ������ ���� Comparator
        ArrayList<Node> mNodes = new ArrayList<>();     // ����Ʈ ���
        ArrayList<Node> result = new ArrayList<>();     // ���� ��� ���
        Node zeroPoint = new Node(0, 0, 0);             // ����(starting point)
        double totalDistance = 0.0;                     // �� �̵��Ÿ�
        
        
        //for (int i = 0; i < LENGTH; ++i) {
          //  mNodes.add(new Node(mRandom.nextInt(LENGTH) + 1, mRandom.nextInt(LENGTH) + 1));     // ��̿� ������ ǣ��Ʈ ��ü ����
          //  mNodes.get(i).distance = mNodes.get(i).getDistance(zeroPoint);                            // ����Ʈ���� ���� �Ÿ� ��� �� ����
        //}
        
        
        //read file
        try{
        	File file=new File("res/input_662.txt");
        	FileReader filereader=new FileReader(file);
        	BufferedReader bufReader = new BufferedReader(filereader);
        	String line=""; int cnt=0;
        	//get N: number of data
        	while((line=bufReader.readLine())!=null){
        		cnt++;
        		if(cnt==6){
        			int idx = line.indexOf(":");
        			String temp = line.substring(idx + 2);
        			N = Integer.parseInt(temp);
        		}
        		if(cnt == 8) break;
        	}
        	
        	//read node data
        	cnt=0;
        	while((line=bufReader.readLine())!=null){
        		cnt++;
        		//parse line [id x_pos y_pos]
        		String temp[]=line.split(" ");
        		int tid=Integer.parseInt(temp[0]);
        		int tx=Integer.parseInt(temp[1]);
        		int ty=Integer.parseInt(temp[2]);
        		
        		mNodes.add(new Node(tid,tx,ty));
        		mNodes.get(cnt-1).distance=mNodes.get(cnt-1).getDistance(zeroPoint);
        		if(cnt==N) break;
        	}
        }catch(FileNotFoundException e){
        	//TODO: handle exception
        }catch(IOException e){
        	System.out.println(e);
        }
        
        // TIME START!
        long start = System.currentTimeMillis();
        
        mNodes.sort(mDistance); // �Ÿ��� ���� ��� �������� ����. ���� ���� ���� ������ ���Ե�.

        for (int i = 0; i < N; ++i) {
            totalDistance += mNodes.get(0).distance;            // ��� �� ���� ª�� �Ÿ����� ����(Greedy Algorithm)
            result.add(mNodes.get(0));                          // ���� ��� ��̿� ����Ʈ ��ü ����
            mNodes.remove(0);                             // ��ü ����
            for (Node obj : mNodes) {
                obj.distance = obj.getDistance(result.get(i));  // ���� ª�� �Ÿ��� ����Ʈ���� �ٽ� �Ÿ��� ��� �� ����
            }

            mNodes.sort(mDistance);                             // �Ÿ��� ���� �������� ����. �ٽ� �� ó�� �ε����� ���� ���� �Ÿ����� ���ĵ�.

        }
        
        long end = System.currentTimeMillis();
        //print total TIME
        System.out.println("total Time: "+(end-start)/1000.0);

        //for (Node obj : result) System.out.print("(" + obj.x + "," + obj.y + ") => "); // ���� ��� ��� ���
        
        
        //write result to output
        try{
        	File file=new File("res/output.txt");
        	BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
        	if(file.isFile()&&file.canWrite()){        		
        		for(int i=0;i<N;i++){
        			bufferedWriter.write(Integer.toString(result.get(i).id));
        			bufferedWriter.newLine();
        		}
        		bufferedWriter.close();
        	}
        	
        }catch(IOException e){
        	e.printStackTrace();
        	System.out.println(e);
        }
        
        
        
    }//main_end
    

}//CLASS Main_end

class DescDistance implements Comparator<Node> {                // ���� ��ü
    @Override
    public int compare(Node o1, Node o2) {
        return Double.compare(o1.distance, o2.distance);
    }
}

*/