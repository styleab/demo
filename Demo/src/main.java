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
		String[] n;//ͳ�Ƶ��ʳ��ֵ�Ƶ��
		Map<String,Integer> map=new TreeMap<String,Integer>();//��ȡ����
		while((m=bf.readLine())!=null){
			String[] words=m.split("[^a-zA-Z]");//��ȡ��ĸ�������ļ���
			for(int i=0;i<words.length;i++){
				String key=words[i].toLowerCase();//����ĸת��ΪСд
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
		//ʹ��switch���ʵ�ֹ���ѡ��
		System.out.println("-------��Ƶ--------");
		System.out.println("1.1�����ʵĲ�ѯ");
		System.out.println("2.��Ƶ�ʽ�����ʾ");
		System.out.println("3.����ļ�");
		Scanner input = new Scanner(System.in);
		int i=input.nextInt();	
		switch(i){
		case 1:
			//��ʾ�û����뵥�ʣ�����ʾ��ʲô���Ÿ���
			System.out.printf("��������Ҫ���ҵĵ��ʣ�����';'����");
			String str= input.next();
			chengcu tj=new chengcu();
			n=tj.oneword(map,str); //ʵ�ֵ������ʵ�Ƶ��
			break;					//��break�ж�ѭ��������һֱִ�У�ֱ�����
		case 2:		
			Scanner sc=new Scanner(System.in);
		    System.out.println("������Ҫ�鿴�ĸ�Ƶ��Ƶ�ĸ���:"); 
			int x = sc.nextInt();  
			chengcu tj1=new chengcu();
			tj1.gaopin(map, x);	//ͨ������������ʵ�ֵ������ʵ�Ƶ��
			break;
		case 3:
			chengcu tj2=new chengcu();
			tj2.out(map);	//ͨ����������������result�ļ�
			break;
		}	
	}
}