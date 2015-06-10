package com.gzucm.volunteer.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gzucm.volunteer.vo.BaseCard2;
import com.gzucm.volunteer.vo.Card2;
import com.gzucm.volunteer.vo.Enlist;

public class TestUnit {
	@Test
	public  void test() {
		// TODO Auto-generated method stub
		List<Enlist> enlistList=new ArrayList<Enlist>();
		List<Card2> items = new ArrayList<Card2>();
		for(int i=0;i<12;i++){
			Enlist enlist=new Enlist();
			enlist.setActivityID(Integer.toString(i));
			enlistList.add(enlist);
		}
		Card2 mCard=null;
		for(int i=0;i<enlistList.size();i++){				
			if (i % 4 == 0) {
				mCard = new Card2(enlistList.get(i));
				
				}
			if (i % 4 != 0) {
				BaseCard2 mBaseCard=null;
				mBaseCard = new BaseCard2(enlistList.get(i));
				mCard.AppendCard(mBaseCard);
				
			}
			if(i % 4+1==4){
				items.add(mCard);
				
			}
		}
		
		showCard(items);
	}
 private static void showCard(List<Card2> items){
	 for(int i=0;i<items.size();i++){
		 System.out.println("main item"+i+":"+items.get(i).getEnlist().getActivityID());
		 for(int j=0;j<items.get(i).getSubCards().size();j++){
			 System.out.println("sub item"+j+":"+items.get(i).getSubCards().get(j).getEnlist().getActivityID());
		 }
	 }
 }
 @Test
	public  void printServerAddress() {
	 System.out.println();
 }
}
