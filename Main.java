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
        Random mRandom = new Random();                  // 포인트생성을 위한 난수함수
        DescDistance mDistance = new DescDistance();    // 어레이 정렬을 위한 Comparator
        ArrayList<Node> mNodes = new ArrayList<>();     // 포인트 어레이
        ArrayList<Node> result = new ArrayList<>();     // 최적 결과 어레이
        Node zeroPoint = new Node(0, 0, 0);             // 원점(starting point)
        double totalDistance = 0.0;                     // 총 이동거리
        
        
        //for (int i = 0; i < LENGTH; ++i) {
          //  mNodes.add(new Node(mRandom.nextInt(LENGTH) + 1, mRandom.nextInt(LENGTH) + 1));     // 어레이에 난수로 푀인트 객체 생성
          //  mNodes.get(i).distance = mNodes.get(i).getDistance(zeroPoint);                            // 포인트에서 원점 거리 계산 및 저장
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
        
        mNodes.sort(mDistance); // 거리에 의해 어레이 내림차순 정렬. 가장 작은 값이 앞으로 오게됨.

        for (int i = 0; i < N; ++i) {
            totalDistance += mNodes.get(0).distance;            // 어레이 안 가장 짧은 거리값을 더함(Greedy Algorithm)
            result.add(mNodes.get(0));                          // 최적 결과 어레이에 포인트 객체 저장
            mNodes.remove(0);                             // 객체 삭제
            for (Node obj : mNodes) {
                obj.distance = obj.getDistance(result.get(i));  // 가장 짧은 거리의 포인트부터 다시 거리를 계산 및 저장
            }

            mNodes.sort(mDistance);                             // 거리에 의해 내림차순 정렬. 다시 맨 처음 인덱스로 가장 작은 거리값이 정렬됨.

        }
        
        long end = System.currentTimeMillis();
        //print total TIME
        System.out.println("total Time: "+(end-start)/1000.0);

        //for (Node obj : result) System.out.print("(" + obj.x + "," + obj.y + ") => "); // 최적 결과 어레이 출력
        
        
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

class DescDistance implements Comparator<Node> {                // 비교자 객체
    @Override
    public int compare(Node o1, Node o2) {
        return Double.compare(o1.distance, o2.distance);
    }
}

*/