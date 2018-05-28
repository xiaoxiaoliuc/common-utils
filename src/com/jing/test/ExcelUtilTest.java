package com.jing.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jing.io.ExcelUtil;

public class ExcelUtilTest {

	/**
	 * 功能：
	 * 
	 * @author 朱志杰 QQ：695520848 Jul 30, 2013 5:51:03 PM
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "d:/a";
		String fileName = "a.xls";
		String realPath = createFile(path, fileName, 0);
		ExcelUtil e = new ExcelUtil(realPath);
		e.setAutoColumnWidth(true);
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[] { "1296016895,流水号：68921681超过了62.734375秒交易未完成，直接退出。 ", "123456" });
		list.add(new Object[] { "12 ", "123456适当放松放松的方式地方了看见了看士大夫士大夫" });
		try {
			e.makeExcel("123", new String[] { "one", "two" }, list);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// try {
		// e.write(0, 2, 3, "你好啊aaa");
		// List<Object[]> list1=e.read(0);
		// for(Object[] objArr : list1){
		// for(Object obj : objArr){
		// System.out.print(obj+" ");
		// }
		// System.out.println();
		// }
		// System.out.println(e.read(0, 1, 1));
		// System.out.println(e.getSheetLastRowNum(0));
		//
		// } catch (Exception e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
	}

	public static String createFile(String path, String fileName, int num) {
		// path表示你所创建文件的路径

		File f = new File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
		// fileName表示你创建的文件名；为txt类型；

		File file = new File(f, fileName);
		if (!file.exists()) {
			return path + "\\" + fileName;
		} else {
			String[] str = fileName.split("("+(num-1)+").");
			if(str.length<2){
				str = fileName.split("\\.");
				str[0] += "(" + num + ").";
				fileName = str[0] + str[1];
			}else {
				str[0] = str[0].substring(0,str[0].length()-1);
				str[0] += "(" + num + ").";
				fileName = str[0] + str[1].substring(1, str[1].length());
			}
			num++;
			return createFile(path, fileName, num);
		}

	}
}
