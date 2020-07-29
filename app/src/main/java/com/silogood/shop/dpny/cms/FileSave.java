package com.silogood.shop.dpny.cms;

import com.silogood.shop.AccController;
import com.silogood.shop.ClothesController;
import com.silogood.shop.ShoesController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;




public class FileSave {
//  **********************************Clothes**********************************
	public void cListWriter(ClothesController clist) throws IOException {
		
		OutputStream os = new FileOutputStream("clist.clist"); // bridge
		ObjectOutputStream out = new ObjectOutputStream(os); // â��

		out.writeObject(clist);

		out.close();
	}

	public ClothesController cListReader() throws IOException, ClassNotFoundException{
		
		File f = new File("clist.clist");
		if(f.isFile()) {
			InputStream is = new FileInputStream("clist.clist"); // bridge
			ObjectInputStream in = new ObjectInputStream(is); // â��

			ClothesController clist = (ClothesController) in.readObject();
			in.close();

			return clist;
		}
		else return null;
		
		
	}
	
//  **********************************Shoes**********************************
	public void sListWriter(ShoesController slist) throws IOException {
		OutputStream os = new FileOutputStream("slist.slist"); // bridge
		ObjectOutputStream out = new ObjectOutputStream(os); // â��

		out.writeObject(slist);

		out.close();
	}

	public ShoesController sListReader() throws IOException, ClassNotFoundException {
		File f = new File("slist.slist");
		if(f.isFile())
		{
		InputStream is = new FileInputStream("slist.slist"); // bridge
		ObjectInputStream in = new ObjectInputStream(is); // â��

		ShoesController slist = (ShoesController) in.readObject();
		in.close();

		return slist;
		}
		else
			return null;
	}
	
//******************************ACC**********************************************
	public void aListWriter(AccController alist) throws IOException {
		OutputStream os = new FileOutputStream("alist.alist"); // bridge
		ObjectOutputStream out = new ObjectOutputStream(os); // â��

		out.writeObject(alist);

		out.close();
	}

	public AccController aListReader() throws IOException, ClassNotFoundException {
		File f = new File("alist.alist");
		if(f.isFile())
		{
		InputStream is = new FileInputStream("alist.alist"); // bridge
		ObjectInputStream in = new ObjectInputStream(is); // â��

		AccController alist = (AccController) in.readObject();
		in.close();

		return alist;
		}
		else return null;
	}
//************************************************************************************
}
