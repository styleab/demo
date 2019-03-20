import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JFrame;


public class chengcu extends JFrame{
	
	//创建一个单个单词比较的方法
	public String []  oneword(Map<String,Integer> map,String m){		
		//把s截取，通过符号截取
		//创建一个集存放用户输入的单词和个数
		//遍历集合，比较
		Map<String,Integer> map1=new TreeMap<String,Integer>();
		String[] m1=m.split(";"); 
		for(int i=0;i<m1.length;i++){    //通过键值映射实现
			for(Entry<String,Integer> entry:map.entrySet()){
				if(m1[i].equals(entry.getKey())){
					map1.put(entry.getKey(),entry.getValue());
					System.out.println("单词"+entry.getKey()+"出现了"+entry.getValue()+"次");
                    break;
				}
			}	
		}
		return m1;	
	}
	
	
	
	//高频词统计
	public void gaopin(Map<String,Integer> map,int k){
		//获取参数k
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){  
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
                return o2.getValue() - o1.getValue(); 
            }  
        }); 
     //输出前k个数
      for(int i = 0; i<k; i++){  
            System.out.println("单词"+list.get(i).getKey()+ "出现了 " +list.get(i).getValue()+"次");  
        }     
    }
	
	

	//存入文件
	public void out(Map<String,Integer> map ){//传入集合
		File f=new File("result.txt");			//创建文件result.txt
		try{
			if(!f.exists()){
				f.createNewFile();				//如果文件不存在则创建文件
			}
			FileWriter ff=new FileWriter(f.getCanonicalFile());//写文件
			for(Entry<String,Integer> entry:map.entrySet()){
				ff.write(entry.getKey()+"/"+entry.getValue()+"    "+"\n");//遍历
			}
			ff.close();							//文件流关闭
			System.out.println("统计输出完成！");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}	
}

