package test_project;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HelloWorld {

	
	/**
	 * 1����ȡ��������֮�͵ĸ���
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	
	public static Double getSum(int a,int b,int n){
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=a+b;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			Integer integer = map.get(arr[i]);
			map.put(arr[i], integer == null?1:integer+1);
		}
		Set<Entry<Integer, Integer>> set = map.entrySet();
		for (Entry<Integer, Integer> entry : set) {
			System.out.println("ÿ�����ӵĸ�����---" + entry.getValue()/n);
		}
		Entry<Integer, Integer> entry = null;
		return (double) (entry.getValue()/n);
	}
	/**
	 * 2����ȡż�����飬����������
	 * @param arr
	 * @return
	 */
	public static int[] getNumber (int [] arr){
		int[] newArr = new int [arr.length];
		int index =0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]%2==0){
				newArr[index]=arr[i];
				index++;
			}
		}
		System.out.println(newArr);
		return newArr;
	}
	/**
	 * 3����ȡָ��Ŀ¼�µ�ǰ�������ļ��л����ļ�����
	 */
	public static void getPageAndNum(File dir){
		  int num=0;
		  File[] files = dir.listFiles();
		  for(int i=0; i<files.length; i++){
			   if(files[i].isDirectory()){
				   getPageAndNum(files[i]);
			   }else{
				   System.out.println("�ļ�������"+files[i].getName());
				   num++;
			   }
		  } 
		  System.out.println("�ļ�������"+num);
	} 
	/**
	 *6�� ������ƴ���ַ������磺main-action-holder��ת��ΪmainActionHolder
	 * @param str
	 * @return
	 */
	public static String concatStr(String str){
		String newConatString ="";
		if(str.contains("-")){
			String[] splitStr = str.split("-");
			if(splitStr.length>1){
				for(int i=1;i<splitStr.length;i++){
					splitStr[i]=splitStr[i].substring(0,1).toUpperCase()+splitStr[i].substring(1);
					System.out.println(splitStr);
				}
				for(int b=0;b<splitStr.length;b++){
					newConatString+=splitStr[b]; 
				}
				
			}
			
		}
		
		return newConatString;
	} 
	
	private static int ticket=10;
	public class SailTicket implements Runnable{
		int n=10000;
	    @Override
	    public void run() {
	        for(int i=1;i<=n;i++){
	            synchronized(this){ 
	                System.out.println(Thread.currentThread().getName()+" - ���˵�"+ticket+"��Ʊ");
	                ticket--;
	            }
	            if(ticket<=0){break;}
	        }
	    }
	}
		public static void SailTicket() throws Exception{
			BufferedInputStream bi = new BufferedInputStream(new FileInputStream("E:\\ARCHIVE\\202002\\day20 am ���ݿ⵼�룬���� am.avi"));
			BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("E:\\ARCHIVE\\202002\\fuzhi.avi"));
			int len = 1;
			byte [] b = new byte[1024];
			long timeMillis = System.currentTimeMillis();
			while((len=bi.read(b))!=-1){
				bo.write(b, 0, len);
			}
			System.out.println(System.currentTimeMillis()-timeMillis);
			bo.flush();
			bi.close();
			bo.close();
		
		}
		public static void main(String[] args) throws Exception {
			//getSum(4,5,6);
			int [] arr = {1,2,3,4,4,5,5,3,8};
			//getNumber(arr);
			//concatStr("main-action-holder-co-vou-hen");
			//File file = new File("E:\\ARCHIVE");
			//getPageAndNum(file);
			SailTicket();
		}

}
