import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;



public class main {
	public static void main(String[] args) throws Exception{
		BufferedReader bf=new BufferedReader(new FileReader("wj.txt"));
		String m;
		String[] n;//统计单词出现的频率
		Map<String,Integer> map=new TreeMap<String,Integer>();//存取数据
		while((m=bf.readLine())!=null){
			String[] words=m.split("[^a-zA-Z]");//截取字母避免多余的计入
			for(int i=0;i<words.length;i++){
				String key=words[i].toLowerCase();//将字母转换为小写
				if(key.length()>0){
					if(!map.containsKey(key)){
						map.put(key,1);
					}else{
						int value=map.get(key);
						value++;
						map.put(key,value);
					}
				}
			}			
		}
		//使用switch语句实现功能选择
		System.out.println("-------词频--------");
		System.out.println("1.1个单词的查询");
		System.out.println("2.高频词进行显示");
		System.out.println("3.输出文件");
		Scanner input = new Scanner(System.in);
		int i=input.nextInt();	
		switch(i){
		case 1:
			//提示用户输入单词，并提示用什么符号隔开
			System.out.printf("请输入你要查找的单词，并用';'隔开");
			String str= input.next();
			chengcu tj=new chengcu();
			n=tj.oneword(map,str); //实现单个单词的频率
			break;					//用break中断循环，否则一直执行，直到最后
		case 2:		
			Scanner sc=new Scanner(System.in);
		    System.out.println("请输入要查看的高频词频的个数:"); 
			int x = sc.nextInt();  
			chengcu tj1=new chengcu();
			tj1.gaopin(map, x);	//通过方法调用来实现单个单词的频率
			break;
		case 3:
			chengcu tj2=new chengcu();
			tj2.out(map);	//通过方法调用来存入result文件
			break;
		}	
	}
}